package secureUserinput;

import java.util.Scanner;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Userinput {

    public static void printName(String firstname) throws ScriptException {

      //Whitelist or Allowed list: - Allow only alpha numeric characters.
      if (!Pattern.matches("[0-9A-Za-z]+", firstname)){
        throw new IllegalArgumentException();
      }
      
      
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = manager.getEngineByName("JavaScript");
      System.out.println(engine.eval(firstname));
      return;
    }
    
    public static void main(String[] args) throws ScriptException{

      try (Scanner eng1 = new Scanner(System.in)) {
        String name = eng1.next();

        printName(name);
      }

    }
    
  }