import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends Thread{
    static OutputStream os;
    static InputStream is;

    public void run() {

        try(Socket peticion = new Socket("localhost", 4999)){

            os = peticion.getOutputStream();
            is = peticion.getInputStream();

            int recibido = is.read();

            System.out.println("Hola cliente " + recibido);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
