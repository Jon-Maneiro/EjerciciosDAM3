import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(6000);
        String cadena = "";
        Socket c;

        System.out.println("Servidor Iniciado");


            c = s.accept();
            //HiloServidor srv = new HiloServidor(c);
            //srv.start();

       PrintWriter fSalida=new PrintWriter(c.getOutputStream(),true);
       BufferedReader fEntrada= new BufferedReader(new InputStreamReader(c.getInputStream()));

       while((cadena = fEntrada.readLine()) != null){
            fSalida.println(cadena.toUpperCase());
       }

    }
}