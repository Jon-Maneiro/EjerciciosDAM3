import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(6000);
        Socket c;

        System.out.println("Servidor Iniciado");

        while(true){
            c = s.accept();
            HiloServidor srv = new HiloServidor(c);
            srv.start();
        }

    }
}