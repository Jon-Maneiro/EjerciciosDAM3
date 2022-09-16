import java.io.*;

public class Main {
    public static void main(String[] args) {

        File f = new File("Text.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String i;

            while((i = reader.readLine() ) != null){
                System.out.println(i);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}