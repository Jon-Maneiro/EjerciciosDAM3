import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {

        while(true) {
            MulticastSocket servidor = new MulticastSocket();
            // El dato que queramos enviar en el mensaje, como array de bytes.
            Scanner sc = new Scanner(System.in);
            System.out.println("Que quieres decirle a los demas");
            String msg = sc.nextLine();
            byte[] dato = msg.getBytes();
            // Usamos la direccion Multicast 230.0.0.1, por poner alguna dentro del rango
            // y el puerto 55557, uno cualquiera que esté libre.
            DatagramPacket dgp = new DatagramPacket(dato, dato.length,
                    InetAddress.getByName("230.0.0.1"), 55557);
            // Envío
            servidor.send(dgp);
        }
    }
}