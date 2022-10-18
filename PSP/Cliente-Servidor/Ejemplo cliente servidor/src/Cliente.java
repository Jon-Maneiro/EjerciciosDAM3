import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

    static OutputStream os;
    static InputStream is;

    public static void main(String[] args) throws IOException {
        //El cliente va a conectarse a esta ip en este puerto
        try(Socket peticion = new Socket("localhost" , 4000)) {

            //Streams de salida y entrada
            os = peticion.getOutputStream();
            is = peticion.getInputStream();

            os.write(4);

            int recibido = is.read();

            System.out.println("El valor recibido por el servidor es: " + recibido);

            //Cerrarlos en orden contrario, claro, y primero el cliente, despues el servidor
            is.close();
            os.close();
            peticion.close();
        }
    }
}
