import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static OutputStream os;
    static InputStream is;
    public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket(4999);

        Socket cliente = new Socket();



        for(int x = 0; x<5;x++) {
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            is = cliente.getInputStream();
            os = cliente.getOutputStream();

            os.write(x+1);

            is.close();
            os.close();
        }

        cliente.close();

    }
}