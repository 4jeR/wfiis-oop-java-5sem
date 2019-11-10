public class Point extends Shape{ 
    Point(int x, int y){
        _x = x;
        _y = y;
    }
    
    @Override
    protected String getName() {
        return "Point";
    }

    @Override
    protected double area(){
        return 0;
    }

    @Override
    protected double volume(){
        return 0;
    }

    
    @Override
    public String toString() {
        return String.format("[" + (double)_x + ", " + (double)_y + "]");
    }


    protected int _x;
    protected int _y;
}