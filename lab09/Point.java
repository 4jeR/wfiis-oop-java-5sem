public class Point{
    public Point(int x, int y){
        _x = x;
        _y = y;
    }

    public String toString(){
        return new String("" + _x + "," + _y);
    }

    public int X(){return _x;}
    public int Y(){return _y;}

    private int _x;
    private int _y;
}
