package Armia;

import java.util.ArrayList;

public class Czolg{
    public Czolg(){
        _rozkazy = new ArrayList<Rozkaz>();
    }

    public String ostatniRozkaz(){
        int last = _rozkazy.size() - 1;
        return "Ostatni rozkaz do mnie: " + _rozkazy.get(last).GetMsg();
    }

    public void wydajRozkaz(Rozkaz rozkaz){
        _rozkazy.add(rozkaz);
    }

    public String toString(){
        String str = new String();

        for(var k : _rozkazy)
            str += k.GetMsg() + "\n";
        
        return str;
    }
    public ArrayList<Rozkaz> _rozkazy;
}