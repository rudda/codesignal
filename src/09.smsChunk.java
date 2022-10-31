import java.io.*;
import java.util.ArrayList;

/*
There is a text-messaging service. It provides you with an API to send SMSs to a user,
but they can be at most 160 characters long.

Your team wants to build a campaign which requires sending long pieces of texts over this service.

You have to build a function which splits the text in chunks so that it can be sent in multiple messages.

Each chunk has to be:
 - up to 160 characters long
 - no word should be split in the middle
 - each chunk has to have its order suffixed in the form of ' (k/n)', e.g. "this is the first chunk (1/2)",
 "this is the second chunk (2/2)"
 - if the text provided to the function is less than 160 characters, no ordering should be suffixed
*/

// Main class should be named 'Solution'
class Solution {
    
    
    public static void main(String[] args) {
     
        String s = "The South Lake Union Streetcar is a streetcar route in Seattle Washington United States. Traveling 1.3 miles (2.1 km) it connects downtown to the South Lake Union neighborhood on Westlake Avenue Terry Avenue and Valley Street. It was the first modern Seattle Streetcar line beginning service on December 12 2007 two years after a separate heritage streetcar ceased operations. It was conceived as part of the redevelopment of South Lake Union into a technology hub with lobbying and financial support from Paul Allen.";
        
        ArrayList<String> result = solution(s);
        
        for( String r : result) {
            
            System.out.println(r + " -> " + r.length());
            System.out.println("");
        }
        
    }
    
    public static String[] wordCount( String s ) {
        return s.split(" "); 
    }
    
    public static ArrayList<String> addSufix(ArrayList<String> r) {
        int count = 1;
        int limit = r.size();
        ArrayList<String> result = new ArrayList<>();
        
        for( String s : r) {
            String sufix = " ("+ count+ "/"+  limit +")";
            s+= sufix;
            result.add(s);
            count++;
        }
        
        return result;
    }
    
    public static ArrayList<String> solution( String s) {
        ArrayList<String> result = new ArrayList<>();
        
        if( s.length() <= 160) {
            result.add(s);
        } else {
            String aux = "";
            String msg[] = wordCount(s);
            String count = "0";
            
            for (int i= 0; i< msg.length; i++) {
                
                String w = msg[i];
                String sufix = " ("+ count+ "/"+  "0" +")";
                
                if( aux.length() <= 160 && (aux+ " "+ w + sufix).length() <= 160) {
                    aux = (aux+ " "+ w);
                } else {
                    
                    result.add(aux);
                    aux = "";
                    
                }
        
            }
            
            if( aux.length() <= 160 ){
                result.add(aux);
                aux = "";
            }
            
            result = addSufix(result);
              
        }
        
        return result;
    }
    
}
