import java.io.*;

public class Main {
    public static void main(String[] args) {

        File f = new File("Text.txt");
        String prov[]={"gipuzkoa","bizkaia","araba"};

        try {
            FileWriter fr = new FileWriter(f);
            for(String i : prov){
                fr.write(i + "\n");
            }
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}