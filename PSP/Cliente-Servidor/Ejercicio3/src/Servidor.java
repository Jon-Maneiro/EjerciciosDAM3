import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;

public class Servidor {
    public static void main(String[] args) throws IOException {

        int puerto = 63774;

        byte msg[] = new byte[1024];

        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor Activo");

        while(true){
            DatagramPacket recibido = new DatagramPacket(new byte[1024],1024);

            socket.receive(recibido);
            System.out.println("paquete recibido");
            System.out.println("Procedencia " + recibido.getAddress());
            System.out.println("Puerto " + recibido.getPort());
            System.out.println("Respondiendo");

            String message = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            msg = message.getBytes();

            DatagramPacket paquete = new DatagramPacket(
                    msg,
                    msg.length,
                    recibido.getAddress(),
                    recibido.getPort()
            );

            socket.send(paquete);

        }
    }
}