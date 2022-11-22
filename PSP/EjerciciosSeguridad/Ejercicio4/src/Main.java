import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(6009);
        Socket c;

        System.out.println("Servidor Iniciado");

        while(true){
            c = s.accept();
            HiloServidor srv = new HiloServidor(c);
            srv.start();
        }


    }
}