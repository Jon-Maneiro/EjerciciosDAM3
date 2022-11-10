import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://dle.rae.es/mierda?m=form");
            int i;
            HttpsURLConnection mere = (HttpsURLConnection) url.openConnection();
            mere.setRequestMethod("GET");
            mere.setRequestProperty("User-Agent" , "Mozilla/5.0");
            InputStream stream = mere.getInputStream();

            File file = new File("busqueda.html");

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            while((i = stream.read()) != -1){
                bw.write((char)i);
            }
            bw.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}