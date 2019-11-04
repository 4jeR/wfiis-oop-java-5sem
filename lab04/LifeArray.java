import java.util.*;



public class LifeArray{
    LifeArray(int sizex, int sizey, int steps, int preset){
        _x = sizex;
        _y = sizey;
        _table = new char[sizey][sizex];
        _steps = steps;
        _preset = preset;

        FillTable(_table, preset);
    }

    public void FillTable(char[][] arr, int preset){
                 
        switch(preset){
            case 0:
                Random generator = new Random();
                for(int i = 0; i < _y; i++){
                    for(int j = 0; j < _x; j++){
                        arr[i][j] = (generator.nextInt(53) < 7) ? 'X': '.' ;
                    }
                }
            break;

            case 1:
                {
                    int mid_x = _x / 2;
                    int mid_y = _y / 2;
                    
                    FillArray(arr, '.');
                    
                    _table[mid_y-1][mid_x-1] = 'X';
                    _table[mid_y-1][mid_x  ] = 'X';
                    _table[mid_y  ][mid_x-1] = 'X';
                    _table[mid_y  ][mid_x+1] = 'X';
                    _table[mid_y+1][mid_x  ] = 'X';
                }
                
            break;

            case 2:
                {
                    int mid_x = _x / 2;
                    int mid_y = _y / 2;
                    FillArray(arr, '.');
                    _table[mid_y-1][mid_x] = 'X';
                    _table[mid_y  ][mid_x] = 'X';
                    _table[mid_y+1][mid_x] = 'X';
                }
                break;
                    
            case 3:
            {

                int mid_x = _x / 2;
                int mid_y = _y / 2;

                FillArray(arr, '.');
                
                _table[mid_y-1][mid_x-1] = 'X';
                _table[mid_y-1][mid_x  ] = 'X';
                _table[mid_y-1][mid_x+1] = 'X';
                _table[mid_y  ][mid_x-1] = 'X';
                _table[mid_y+1][mid_x  ] = 'X';
            }
            
            break;
        }
        
        
    }
    
    public void PrintTable(char[][] arr){
        for(int i = 0; i < _y; i++){
            for(int j = 0; j < _x; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void ClearConsole(int step){
        System.out.println();
        System.out.println(" ------ " + step + " ------ ");
        System.out.println();
        
    }
    
    public void FillArray(char [][] arr, char chr){
        for(int i = 0; i < _y; i++){
            for(int j = 0; j < _x; j++){
                arr[i][j] = chr;
            }
        }
    }

    public void RunGame() throws InterruptedException{
        for(int i = 0; i < _steps; i++){
            ClearConsole(i+1);
            PrintTable(_table);
            ApplyLogic();  
            
            Thread.sleep(420);
        }
    }


    public void ApplyLogic(){
        
        char[][] _table_next = new char[_y][_x];
        CopyTable(_table_next, _table);

        // System.out.println("Udalo sie prekopiowac? V"); // ok kopiowanie dziala
        // PrintTable(_table_next);


        for(int i = 0; i < _y; i++){
            for(int j = 0; j < _x; j++){
            // for each cell
                if(_table[i][j] == '.'){
                    int cN = CountNeighbours(_table, i, j);
                    if(cN == 3){
                        _table_next[i][j] = 'X';
                    }
                    else 
                        _table_next[i][j] = '.';
                }

                else if(_table[i][j] == 'X'){
                    int cN = CountNeighbours(_table, i, j);
                        if( cN == 2 || cN == 3){
                            _table_next[i][j] = 'X';
                        }
                    else 
                        _table_next[i][j] = '.';
                }
            }
        }
        CopyTable(_table, _table_next);
    }

    public void CopyTable(char[][] dest, char[][] src){
        
        for(int i = 0; i < _y; i++){
            for(int j = 0; j < _x; j++){
                dest[i][j] = src[i][j];
            }
        }
    }
    

    public int CountNeighbours(char[][] table, int y, int x){
        int sum = 0;

        for(int i = y-1; i <= y+1; i++){
            
            if(0 <= i && i < _y){
                for(int j = x-1; j <= x+1; j++){
                    if(0 <= j && j < _x){
                        if(table[i][j] == 'X'){
                            if( i == y && j == x) continue;
                            ++sum;
                        }
                    }
                }
            }
        }
        

        
        return sum;
    }

   
    
    
    int _x;
    int _y;
    int _steps;
    int _preset;
    char[][] _table;
}