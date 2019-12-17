public class Word{
    public Word(String s1, String s2){
        str1 = s1;
        str2 = s2;
    }
    public String Str1(){return str1;}
    public String Str2(){return str2;}

    public String toString(){
        return str2 + " " + str1;
    }

    private String str1;
    private String str2;
}