public class Cube extends Square{ 
    

    Cube(double z, int x, int y){
        super(z, x, y);
    }

    @Override
    protected String getName() {
        return "Cube";
    }

    @Override
    protected double area(){
        return 6.0 * super.area();
    }

    @Override
    protected double volume(){
        return _z * super.area();
    }
    
    @Override
    public String toString() {
        return super.toString() + "; depth = " + (double)_z;
    }
}