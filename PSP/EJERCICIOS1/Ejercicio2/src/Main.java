import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

      Runtime r = Runtime.getRuntime();
        String comando = "CMD /C DIR";
        Process p;
        int exitValue;
        try {
            p=r.exec(comando);
            BufferedReader lectura = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea;

            while((linea = lectura.readLine())!=null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


/*
        try {
            Process proceso= new ProcessBuilder("CMD" , "/C" , "DIR").start();
            int valor = proceso.waitFor();
            System.out.println(valor);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }*/


    }
}