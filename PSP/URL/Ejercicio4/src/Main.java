import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //https://www.imdb.com/find?q=star+wars&ref_=nv_sr_sm

        Scanner sc = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<>();
        String s = "";
        boolean terminado = false;
        while(!terminado){
            System.out.println("Introduce la palabra que quieres añadir a la busqueda");
            palabras.add(sc.nextLine());
            System.out.println("¿Quieres seguir?Y/N");
            if(sc.nextLine().toUpperCase().equals("N")){
                terminado = true;
            }
        }

        try {

            String a = "";

            for( String i : palabras){
                a = a + i + "+";
            }

            a = removeLastChar(a);
            System.out.println(a);
            URL url = new URL("https://www.imdb.com/find?q=" + a +"&ref_=nv_sr_sm");
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

    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }

}

