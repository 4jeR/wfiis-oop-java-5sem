import java.io.*;
import java.util.ArrayList;


public class lab9{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Prosze podac w argumencie wywolania programu nazwe pliku wejsciowego .txt!");    
        }
        else
        try{
            BufferedReader fr = new BufferedReader(new FileReader("in.txt"));
            
            String[] line = fr.readLine().split(" ");
            int width = Integer.valueOf(line[0]);
            int height = Integer.valueOf(line[1]);
            String out_file = line[2];
            
            line = fr.readLine().split(" ");

            int num_of_points = Integer.valueOf(line[0]);
            double Eps = 1000.0;
            
            ArrayList<Point> points = new ArrayList<Point>(num_of_points);

            for(int i = 0; i < num_of_points; ++i){
                line = fr.readLine().split(",");
                int x = Integer.valueOf(line[0]);
                int y = Integer.valueOf(line[1]);
                points.add(new Point(x, y));
            }

            String data=""; 
            

            for(int i = 0; i < width; ++i){
                for(int j = 0; j < height; ++j){
                    double minDist = width * height;
                    double minDist2 = width * height;

                    int minIdx = -1;
                    int minIdx2 = -1;

                    // znalezienie pierwszego minimum
                    for(int k = 0; k < num_of_points; ++k){ 
                        int xx = i - points.get(k).X();
                        int yy = j - points.get(k).Y();    
                
                        double sqrt_dist = xx*xx + yy*yy;

                        if(sqrt_dist < minDist){
                            minDist = sqrt_dist;
                            minIdx = k;
                        }
                    }

                    // znalezienie drugiego minimum
                    for(int k = 0; k < num_of_points; ++k){ 
                        int xx = i - points.get(k).X();
                        int yy = j - points.get(k).Y();
                
                
                        double sqrt_dist = xx*xx + yy*yy;
                        // System.out.println("Distance -> " + dist);

                        if(sqrt_dist < minDist && minIdx != minIdx2){
                            minDist = sqrt_dist;
                            minIdx2 = k;
                        }
                    }
                    // r1 g1 b1 r2 g2 b2 r3 g3 b3
                    if(Math.abs(minDist2 - minDist) < Eps){
                        data += "0 0 0 ";
                        
                        // czesc linii
                    }
                    else if(Math.abs(minDist2 - minDist) == 0){
                        data += "255 0 0 ";
                    }
                    else{
                        data += "255 255 255 ";
                        // 255 255 255 dla tla
                    }
                }
            } // end of i,j loop

            // zapis danych do pliku
            try{
                FileWriter fw = new FileWriter(out_file);    

                fw.write("P3\n");
                fw.write("#Bartlomiej Dlugosz\n");
                fw.write(width + " " + height + "\n");
                fw.write("255\n");
                fw.write(data); 
                fw.close();   
            }
            catch(Exception e ){ 
                System.out.println(e);
            }

            
            fr.close();
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }
}