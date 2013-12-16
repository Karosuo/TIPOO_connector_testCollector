import java.io.*;
import java.net.*;

public class ReverseTest {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.err.println("Usage:  java ReverseTest string_to_reverse");
                System.exit(1);
            }
            String stringToReverse = URLEncoder.encode(args[0]);

            URL url = new URL("http://java.sun.com/cgi-bin/backwards");
            URLConnection connection = url.openConnection();

            PrintStream outStream = new PrintStream(connection.getOutputStream());
            outStream.println("string=" + stringToReverse);
            outStream.close();

            DataInputStream inStream = new DataInputStream(connection.getInputStream());
            String inputLine;

            while ((inputLine = inStream.readLine()) != null) {
                System.out.println(inputLine);
            }
            inStream.close();
        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
        }
    }
}