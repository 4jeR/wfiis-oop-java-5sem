public class lab3string{

    public static int dlugosc(String s){
        return s.length();
    }

    public static int ile_razy_literka_wystepuje(String str, char chr){
        int sum = 0;
        
        for(int i = 0; i < str.length(); ++i)
            if(str.charAt(i) == chr)
                ++sum;
        
        return sum;
    }

    public static boolean czy_takie_same(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        else 
            for(int i = 0; i < str1.length(); ++i)
                if(str1.charAt(i) != str2.charAt(i))
                    return false;
                
        return true;
    }

    public static String wspak(String str){
        String result = new String();   

        for(int i = 0; i < str.length(); ++i)
            result += str.charAt(str.length() - i - 1);
        
        return result;
    }

    public static boolean czy_plaindrom(String str){
        for(int i = 0; i < str.length() / 2; ++i)
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
            
        return true;
    }

    public static boolean czy_abecadlowe(String str){
        for(int i = 1; i < str.length(); ++i)
            if(str.charAt(i-1) > str.charAt(i))
                return false;
            
        return true;
    }

    

    public static String rot13(String str){
        String rotatedString = new String();
    
        char[] alfabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                        'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                        'y', 'z'};

        char[] specials = {'!', '@', '#', '$', '%', '^', '&', '*',
                           '(', ')', '-', '_', '=', '+', ';', ':',
                           ' ', ',', '.', '<', '>', '?', '|', '/',
                           '1', '2', '3', '4', '5', '6', '7', '8',
                           '9', '0'};

        
        for(int i = 0; i < str.length(); ++i){
            Character currChar = str.charAt(i);
            boolean isCurrCharUpper = Character.isUpperCase(currChar);
            
            for(int j = 0; j < 34; ++j)
                if(currChar == specials[j])
                    rotatedString += specials[j];
            

            for(int k = 0; k < 26; ++k){
                if(alfabet[k] == currChar || alfabet[k] == Character.toLowerCase(currChar)){
                    rotatedString += (isCurrCharUpper) ? Character.toUpperCase(alfabet[(k+13) % 26]): alfabet[(k+13) % 26];
                    break;
                }
            }
        }
        return rotatedString;  
    }
}