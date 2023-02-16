package secureDeserialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class SerDes {

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        Employee e = new Employee(); //Creating a Employee object
        e.setId(1);
        e.setName("CodecO");

        //Serailization
        FileOutputStream fileoutput = new FileOutputStream("/Users/pravinshinde/Documents/Secure Coding Java/Deserialization/abc_example.ser");
        ObjectOutputStream objectoutput = new ObjectOutputStream(fileoutput);
        objectoutput.writeObject(e);
        objectoutput.close();
        fileoutput.close();

        //Deserialization
        FileInputStream fileinput = new FileInputStream("/Users/pravinshinde/Documents/Secure Coding Java/Deserialization/abc_example.ser");
        ObjectInputStream objectinput = new ObjectInputStream(fileinput);

        // Pattern- based Filter for individual streams. "Replace the pattern which you want to apply in - '!pattern1. pattern2' "
        ObjectInputFilter filesOnlyFilter = ObjectInputFilter.Config.createFilter("!pattern1.* pattern2;");
        objectinput.setObjectInputFilter(filesOnlyFilter);

        //Pattern-based Filter for all streams
        // ObjectInputFilter.Config.setSerialFilter("!patterns.*");

        //recreating object
        Employee reCreatedObj = (Employee)objectinput.readObject();
        System.out.println("The Deserialized Object is: "+ reCreatedObj.getName());
        objectinput.close();
        fileinput.close();

    }
    
}
