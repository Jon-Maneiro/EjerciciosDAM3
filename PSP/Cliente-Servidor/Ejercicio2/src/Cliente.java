import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    public static void main(String[] args) {

        PrintWriter fSalida;
        BufferedReader fEntrada;
        Scanner sc  =new Scanner(System.in);

        try (Socket peticion = new Socket("localhost", 6000)) {

            System.out.println("OIAFOang");

            fSalida = new PrintWriter(peticion.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(peticion.getInputStream()));

            fSalida.println(sc.nextLine());

            System.out.println("El texto recibido es: " + fEntrada.readLine());
            //Math.floor(Math.random() * max);


            fSalida.close();
            fEntrada.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
