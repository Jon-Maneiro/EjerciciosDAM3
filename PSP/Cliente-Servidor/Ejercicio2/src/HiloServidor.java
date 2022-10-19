import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor extends Thread{

    static PrintWriter fSalida;
    static BufferedReader fEntrada;
    Socket cliente;

    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;
        // se crean los flujos de entrada y salida
        this.fSalida=new PrintWriter(cliente.getOutputStream(),true);
        this.fEntrada= new BufferedReader (new InputStreamReader(cliente.getInputStream()));
    }

    @Override
    public void run(){

        try {

            System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
            //System.out.println(fEntrada.readLine());
            String informacionRecibida = fEntrada.readLine();
            System.out.println("Informacion recibida: " + informacionRecibida);
            informacionRecibida = informacionRecibida.toUpperCase();

            fSalida.println(informacionRecibida);

            fEntrada.close();
            fSalida.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
