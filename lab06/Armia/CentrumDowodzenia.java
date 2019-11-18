package Armia;

import java.util.ArrayList;

public class CentrumDowodzenia{
    public CentrumDowodzenia(){
        _czolgi = new ArrayList<Czolg>();
    }

    public void zarejestrujCzolg(Czolg czolg){
        _czolgi.add(czolg);
    }

    public void wydajRozkaz(String index, Rozkaz rozkaz ){
        int idx = Integer.valueOf(index) - 1;
        
        _czolgi.get(idx).wydajRozkaz(rozkaz);
    }

    public String toString(){
        String str = new String("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:");
        for(int i = 0; i < _czolgi.size(); ++i){
            str += "\nCzolg nr " + (i+1) + " otrzymal rozkazy:\n";
            str += _czolgi.get(i).toString();
        }
        return str;
    }

    public ArrayList<Czolg> GetCzolgi(){return _czolgi;}

    private ArrayList<Czolg> _czolgi;

}