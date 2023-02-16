package secureHTMLEncoding;

import java.util.Scanner;

import org.apache.commons.lang3.StringEscapeUtils;

public class secureHTMLforXSS {

    public static void main(String[] args){
        

        try (Scanner eng1 = new Scanner(System.in)) {
            String userinput = eng1.next();

            // Allowed list or whitelist the user supplied input
            // if (!Pattern.matches("[0-9A-Za-z@.]+", userinput)){
            //     throw new IllegalArgumentException();
            // }

            // Additional layer of security to mitigate Cross-Site Scripting attack.
            String result_output = StringEscapeUtils.escapeHtml4(userinput); // script tags will be  converted to '<' to &lt; and '>'' to &gt;
            //Note StringEscapeUtils is depracated from v3.6

            System.out.println(result_output);
        }


    }

    
    
}