import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws IOException {
        int puerto = 63774;

        byte msg[] = new byte[1024];

        DatagramSocket socket = new DatagramSocket();

        String mensaje = "hola";

        msg = mensaje.getBytes();

        DatagramPacket paquete = new DatagramPacket(
                msg,
                msg.length,
                InetAddress.getByName("localhost"),
                puerto
        );

        socket.send(paquete);
        System.out.println("Enviado");

        DatagramPacket recebi = new DatagramPacket(new byte[1024],1024);
        socket.receive(recebi);
        System.out.println("paquete recibido");
        System.out.println("Procedencia " + recebi.getAddress());
        System.out.println("Puerto " + recebi.getPort());

        System.out.println(recebi.getData().toString());

    }
}
