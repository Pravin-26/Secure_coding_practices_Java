package SSRF;


import java.net.URL;
import java.net.MalformedURLException;

public class secureSSRF {


  
  // Define the list of allowed domains
  private static final String[] ALLOWED_DOMAINS = { "example.com", "trusteddomain.com" };
  
  // Check if the URL is allowed
  public static boolean isURLAllowed(String urlString) {
    try {
      URL url = new URL(urlString);
      String domain = url.getHost();
      
      // Check if the domain is in the list of allowed domains
      for (String allowedDomain : ALLOWED_DOMAINS) {
        if (domain.endsWith("." + allowedDomain) || domain.equals(allowedDomain)) {
          return true;
        }
      }
    } catch (MalformedURLException e) {
      // Handle the invalid URL
    }
    
    // If the URL is not allowed, return false
    return false;
  }
  
  // Sample usage of the isURLAllowed method
  public static void main(String[] args) {
    String url1 = "http://example.com/api/data";
    String url2 = "http://attacker.com/malicious";
    
    System.out.println("Is " + url1 + " allowed? " + isURLAllowed(url1));
    System.out.println("Is " + url2 + " allowed? " + isURLAllowed(url2));
  }
}
