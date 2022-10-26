import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {



    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket servidor = new ServerSocket(5333);

        Socket cliente = new Socket();

        ObjectOutputStream outObjeto;//= new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inObjeto;//=new ObjectInputStream(socket.getInputStream());

        while(true){
            cliente = servidor.accept();
            System.out.println("Cliente Conectado");
            Numeros num = new Numeros((int)(Math.floor(Math.random() * 10)),(int)(Math.floor(Math.random() * 10)));
            outObjeto = new ObjectOutputStream(cliente.getOutputStream());
            inObjeto = new ObjectInputStream(cliente.getInputStream());

            outObjeto.writeObject(num);

            num = (Numeros)inObjeto.readObject();

            System.out.println("Los datos suministrados fueron: " + num.getNum1() + " , "
             + num.getNum2());
            System.out.println("El resultado es: " + num.getResultado());

        }

    }
}