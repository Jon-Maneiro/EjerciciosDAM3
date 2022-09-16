import java.io.*;

public class Main {
    public static void main(String[] args) {

        File f = new File("Text.txt");
        int numeroLineas = 15;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for(int x = 0;x <= numeroLineas;x++){
                bw.write("Linea numero" + x);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}