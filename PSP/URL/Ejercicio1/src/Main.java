import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {

        try {
            URL u = new URL("http://www.egibide.com");

            URLConnection urlConnect = u.openConnection();

            /**
            InputStream stream = urlConnect.getInputStream();
            int i;
            */

            System.out.println("FILE:" +  u.getFile());
            System.out.println("HOST:" +  u.getHost());
            System.out.println("PROTOCOL:" +  u.getProtocol());
            System.out.println("USER INFO:" +  u.getUserInfo());
            System.out.println("PORT:" +  u.getPort());
            System.out.println("QUERY:" +  u.getQuery());
            System.out.println("AUTHORITY:" +  u.getAuthority());
            System.out.println("PATH:" +  u.getPath());
            System.out.println("REF:" +  u.getRef());
            System.out.println("CONTENT:" +  u.getContent());
            System.out.println("DEFAULT PORT:" +  u.getDefaultPort());


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}