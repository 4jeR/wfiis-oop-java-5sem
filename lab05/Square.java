public class Square extends Point{ 
    

    Square(double z, int x, int y){
        super(x,y);
        _z = z;
    }

    @Override
    protected String getName() {
        return "Square";
    }

    @Override
    protected double area(){
        return _z * _z;
    }

    @Override
    protected double volume(){
        return 0;
    }
    
    @Override
    public String toString() {
        return "Corner = " + super.toString() + "; side = " + (double)_z;
    }


    protected double _z;
}