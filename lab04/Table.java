import java.util.Random;

public class Table {
    Table(int x, int y, int preset){
        _x = x;
        _y = y;
        _preset = preset;
        _tab = new char[y][x];
        SetPreset(_tab, preset);
    }


    public void SetPreset(char[][] arr, int preset){
        switch(preset){
            case 0:
                Random generator = new Random();
                for(int i = 0; i < _y; i++)
                    for(int j = 0; j < _x; j++)
                        arr[i][j] = (generator.nextInt(53) < 7 || generator.nextInt(32) > 22) ? 'X': '.' ;
            break;

            case 1:
                {
                    int mid_x = _x / 2;
                    int mid_y = _y / 2;
                    
                    FillArray(arr, '.');
                    
                    _tab[mid_y-1][mid_x-1] = 'X';
                    _tab[mid_y-1][mid_x  ] = 'X';
                    _tab[mid_y  ][mid_x-1] = 'X';
                    _tab[mid_y  ][mid_x+1] = 'X';
                    _tab[mid_y+1][mid_x  ] = 'X';
                }
            break;

            case 2:
                {
                    int mid_x = _x / 2;
                    int mid_y = _y / 2;

                    FillArray(arr, '.');

                    _tab[mid_y-1][mid_x] = 'X';
                    _tab[mid_y  ][mid_x] = 'X';
                    _tab[mid_y+1][mid_x] = 'X';
                }
            break;
                    
            case 3:
                {
                    int mid_x = _x / 2;
                    int mid_y = _y / 2;

                    FillArray(arr, '.');
                    
                    _tab[mid_y-1][mid_x-1] = 'X';
                    _tab[mid_y-1][mid_x  ] = 'X';
                    _tab[mid_y-1][mid_x+1] = 'X';
                    _tab[mid_y  ][mid_x-1] = 'X';
                    _tab[mid_y+1][mid_x  ] = 'X';
                }
            break;

            default:
            
            break;
        } 
    }


    public void PrintTable(char[][] arr){
        for(int i = 0; i < _y; i++){
            for(int j = 0; j < _x; j++)
                System.out.print(arr[i][j]);
            
            System.out.println();
        }
    }


    public void FillArray(char [][] arr, char chr){
        for(int i = 0; i < _y; i++)
            for(int j = 0; j < _x; j++)
                arr[i][j] = chr;
    }


    public void CopyTable(char[][] dest, char[][] src, int sizex, int sizey){
        for(int i = 0; i < sizey; i++)
            for(int j = 0; j < sizex; j++)
                dest[i][j] = src[i][j];
    }
    

    public int GetX(){
        return _x;
    }


    public int GetY(){
        return _y;
    }


    public int GetPreset(){
        return _preset;
    }


    public char[][] GetTab(){
        return _tab;
    }


    private int _x;
    private int _y;
    private int _preset;
    private char[][] _tab;
}