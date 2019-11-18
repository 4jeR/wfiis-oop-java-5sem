package Armia;

public class Rozkaz{
    public Rozkaz(String str){
        _msg = new String(str);
    }

    
    public String GetMsg(){return _msg;}
    private String _msg;

    
}