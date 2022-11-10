import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {

        URL u = null;
        try {
            u = new URL("https://www.google.com");
            URLConnection urlConnect = u.openConnection();


             InputStream stream = urlConnect.getInputStream();
             int i;

             while((i = stream.read()) != -1){
                 System.out.print((char) i);
             }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}