public class LifeArray{
    LifeArray(int sizex, int sizey, int steps, int preset){
        _steps = steps;
        _table = new Table(sizex, sizey, preset);
    }


    public void PrintTable(char[][] arr){
        _table.PrintTable(arr);
    }


    public void ClearConsole(int step){
        System.out.println();
        System.out.println(" ------ " + step + " ------ ");
        System.out.println();
        
    }
    

    public void FillArray(char [][] arr, char chr){
        _table.FillArray(arr, chr);
    }


    public void RunGame() throws InterruptedException{
        for(int i = 0; i < _steps; i++){
            ClearConsole(i+1);
            PrintTable(_table.GetTab());
            ApplyLogic();  
            
            Thread.sleep(220);
        }
    }


    public void ApplyLogic(){
        int size_x = _table.GetX();
        int size_y = _table.GetY();

        char[][] _table_next = new char[size_y][size_x];

        CopyTable(_table_next, _table.GetTab(), size_x, size_y);

        for(int i = 0; i < size_y; i++){
            for(int j = 0; j < size_x; j++){
                if(_table.GetTab()[i][j] == '.'){
                    int cN = CountNeighbours(_table.GetTab(), i, j, size_x, size_y);
                    if(cN == 3)
                        _table_next[i][j] = 'X';
                    else 
                        _table_next[i][j] = '.';
                }
                else if(_table.GetTab()[i][j] == 'X'){
                    int cN = CountNeighbours(_table.GetTab(), i, j, size_x, size_y);
                        if( cN == 2 || cN == 3)
                            _table_next[i][j] = 'X';
                    else 
                        _table_next[i][j] = '.';
                }
            }
        }
        CopyTable(_table.GetTab(), _table_next, size_x, size_y);
    }


    public void CopyTable(char[][] dest, char[][] src, int sizex, int sizey){
        _table.CopyTable(dest, src, sizex, sizey);
    }
    

    public int CountNeighbours(char[][] table, int curr_y, int curr_x, int sizex, int sizey){
        int sum = 0;
        for(int i = curr_y-1; i <= curr_y+1; i++){
            if(0 <= i && i < sizey){
                for(int j = curr_x-1; j <= curr_x+1; j++){
                    if(0 <= j && j < sizex){
                        if(table[i][j] == 'X'){
                            if( i == curr_y && j == curr_x) continue;
                            else ++sum;
                        }
                    }
                }
            }
        }
        return sum;
    }

    private static int _steps;
    private Table _table;
}