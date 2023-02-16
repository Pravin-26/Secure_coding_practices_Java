package secureOScommands;


import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;


public class OScodeexecution {


    public static void filelists(String filedirectory) throws Exception{

        // Allowed list or whitelist the user supplied input
        if (!Pattern.matches("[0-9A-Za-z@.]+", filedirectory)){
            throw new IllegalArgumentException();
          }

        try {    
      
            // create new file object
            File name1 = new File(filedirectory);
                                    
            // array of files and directory
            String[] paths = name1.list();
               
            // for each name in the path array
            for(String path:paths) {
            
               // prints filename and directory name
               System.out.println(path);
            }
            
         } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
         }
    }

    public static void main(String[] args) throws Exception{

        try (Scanner eng1 = new Scanner(System.in)) {
          String filedirectory = eng1.next();
          filelists(filedirectory);
        }
  
      }



    }