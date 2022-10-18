import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static OutputStream os;
    static InputStream is;

    public static void main(String[] args) throws IOException {
        //El servidor escucha en ese puerto
        ServerSocket servidor = new ServerSocket(4000);

        //Devuelve un elemento tipo socket
        //cada vez que haya una peticion, se ejecuta el accept, que genera un socket
        Socket cliente;
        cliente = servidor.accept();//cada vez que se genera una peticion, se guarda aqui?

        System.out.println("Conexion cliente");

        is = cliente.getInputStream();
        os = cliente.getOutputStream();

        int valor = is.read();
        System.out.println("El valor recibido desde el cliente es " + valor);

        int total = valor * 2;
        os.write(total);

        //El servidor de normal se quedaria abierto

        os.close();
        is.close();
        cliente.close();

    }
}