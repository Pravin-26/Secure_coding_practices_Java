# Secure_coding_practices_Java


Written Java secure coding practices for Deserialization, XML Parsing, User input, parsing OS commands.

For Secure Deserialization - Added a 'Pattern-based filter' for individual streams & all streams(optional) using 'setObjectInputFilter' method.

For Secure XML Parsing: - Disabled external entities & DTD's using 'setFeature' property in 'javax.xml.parsers.DocumentBuilder'.

For Secure User Input: - Allowed only alphanumeric characters by adding a 'Whitelists or Allwoed listss'.

For Secure OS commands: - Added a 'Whitelists' & used 'java.io.File' for executing of 'Bash shell' commands on server side/program side.

For Secure HTML Encoding: - Used 'HTMLEncoding' method through 'Apache Commons IO Commands' library to convert <script> tags into HTML entities 
like &lt;script&gt; 
