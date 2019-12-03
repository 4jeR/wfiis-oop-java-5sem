import java.io.*;


public class lab8{
    public static void main(String[] args)throws Exception{
        try{
            if(args.length != 2){
                throw new Exception("[wyjatek] Nalezy wpisac poprawne dwa pliki: wejsciowy i wyjsciowy!"); 
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        double avg = 0.0;
        int i = 0;
        try{
            BufferedReader fr = new BufferedReader(
                new FileReader(args[0]));
            String line; 
            while( (line = fr.readLine() ) != null ){
                avg += Double.parseDouble(line);
                if (Double.parseDouble(line) == Double.POSITIVE_INFINITY) {throw new RuntimeException();}
                // fr.close();         // po odkomentowaniu powinien zostac wylapany wyjatek IOException
                ++i;
            }
            if(i == 0) throw new ArithmeticException(); // jezeli w pliku nie ma danych - powinien zostac wylapany wyjatek  ArithmeticException
            else avg /= i;
            fr.close();
        }
        catch(IOException e){
            System.out.println(" [wyjatek] Nastapil blad zwiazany z zapisywaniem/odczytywaniem danych \n- prawdopodobnie plik nie istnieje lub zostal usuniety podczas wykonywania programu!");
        }  
        catch(NumberFormatException e){
            System.out.println(" [wyjatek] Nastapil blad - prosze sprawdzic, czy w pliku in.txt na pewno zapisane sa liczby (ewentualnie usunac puste linie w pliku !)");
        } 
        catch(ArithmeticException e){
            System.out.println(" [wyjatek] Nastapil blad brak liczb do wyliczenia sredniej !");
        }
        catch(RuntimeException e){
            System.out.println(" [wyjatek] Nastapil blad - w pliku sa zbyt duze liczby, by program sobie z tym poradzil !");
        }    
        catch(Exception e){
            System.out.println(e);
        } 
        finally{
            try{
                FileWriter fw = new FileWriter(args[1]);    
                fw.write(String.valueOf(avg)); 
                fw.close();  
            }
            catch(Throwable e ){ 
                System.out.println(" [wyjatek] Nastapil blad zwiazany z zapisem do pliku po wyliczeniu sredniej!");
            }
        }
    }
}