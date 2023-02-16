import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//Steps
//Methods

//1.Get the document builder
//2.Get Document
//3.Normalize the xml structure.
//4. TagName.



//

public class XMLParserJava {

    public static void main (String [] args) {

        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        String FEATURE = null;
        try{
            //Get the document builder
            DocumentBuilder builder =  factory.newDocumentBuilder();

            FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
            factory.setFeature(FEATURE, true);
            
            FEATURE = "http://xml.org/sax/features/external-general-entities";
            factory.setFeature(FEATURE, false);
            
            FEATURE = "http://xml.org/sax/features/external-parameter-entities";
            
            factory.setFeature(FEATURE, false);
            
            // Disable external DTDs as well
            FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
            factory.setFeature(FEATURE, false);
            
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);



            //Remaining parser logic
            
            //Get Document
            Document document = builder.parse(new File("/Users/pravinshinde/Documents/Java/XML_Parser/Laptop.XML"));

            //Normalize the xml structure.
            document.getDocumentElement().normalize();

            //TagName
            NodeList laptopList = document.getElementsByTagName("laptop");
            for (int i = 0; i < laptopList.getLength(); i++){
                Node laptop = laptopList.item(i);

                if (laptop.getNodeType() == Node.ELEMENT_NODE) {
                    Element laptopElement = (Element) laptop;
                    System.out.println("Laptop Name: " + laptopElement.getAttribute("name"));

                    


                    NodeList laptopDetails = laptop.getChildNodes();
                    for (int j = 0; j < laptopDetails.getLength(); j++) {
                        Node detail = laptopDetails.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE){
                            Element detailElement = (Element) detail;
                            System.out.println("  " + detailElement.getTagName() + " : " + detailElement.getAttribute("value"));

                        }

                    }


                }



            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

