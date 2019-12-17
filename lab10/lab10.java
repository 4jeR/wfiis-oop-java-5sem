import java.io.*;
import java.util.*;

public class lab10{
    public static void main (String[] args){    
        List<Word> list = new ArrayList<Word>(); 
            try{
                BufferedReader fr = new BufferedReader(new FileReader("out.txt"));
                String line;
                while( (line = fr.readLine() ) != null ){
                    String[] words = line.split(" ");
                    list.add(new Word(words[0], words[1]));
                }
                
                fr.close();
            }catch(Exception e){System.out.println(e);}
    
        if(args.length == 1){
            int indx = 0;
            for(Word w : list){
                indx++;
                if(args[0].equals(w.Str1())){
                    System.out.println(w.Str2());
                    break;
                }
                else if(args[0].equals(w.Str2())){
                    System.out.println(w.Str1());
                    break;
                }
                else if(indx == list.size()){
                    System.out.println("Nie ma takiego slowa w slowniku!");
                    break;
                }
            }
        }
        else if(args.length == 2){
            if(args[0].equals("del")){
                for(int idx = 0; idx < list.size(); ++idx){
                    if(args[1].equals(list.get(idx).Str1()) || args[1].equals(list.get(idx).Str2()) ){
                        System.out.println("usunieto slowo: " + list.get(idx).Str1());
                        list.remove(idx);
                        break;
                    }
                    else if (idx == list.size()-1){
                        System.out.println("nie ma takiego slowa - nic nie usuwam!");
                        break;
                    }
                }
            }
        }
        else if (args.length == 3){
            if(args[0].equals("add")){
                try{
                    FileWriter fw = new FileWriter("out.txt", true);   
                    Word toAdd = new Word(args[1],args[2]);
                    boolean canAdd = true;
                    for(Word w : list){
                        if(
                            (w.Str1().equals(toAdd.Str1()) || w.Str1().equals(toAdd.Str2()))
                            &&
                            (w.Str2().equals(toAdd.Str1()) || w.Str2().equals(toAdd.Str2()))
                        )
                        {
                            canAdd = false;
                        } 
                        else{
                            canAdd = true;
                        }
                    }
                    if(canAdd)
                        list.add(toAdd);

                    fw.close(); 
                }catch(Exception e){System.out.println(e);}
            }
        }
        
        try{
            FileWriter fw = new FileWriter("out.txt");    
            
            for(int i = 0; i < list.size(); ++i){
                fw.write(list.get(i).Str1() + " " + list.get(i).Str2() + "\n");
            }

            fw.close(); 
        }catch(Exception e){System.out.println(e);}
    }
}