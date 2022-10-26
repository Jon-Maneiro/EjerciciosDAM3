import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {


    public static void main(String[] args) {

        ObjectOutputStream outObjeto;//= new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inObjeto;//=new ObjectInputStream(socket.getInputStream());
        Numeros num;

        try(Socket peticion = new Socket("localhost" , 5333)){
            outObjeto = new ObjectOutputStream(peticion.getOutputStream());
            inObjeto = new ObjectInputStream(peticion.getInputStream());
            num = (Numeros) inObjeto.readObject();

            System.out.println("Han llegado: " + num.getNum1() + " , " + num.getNum2());
            num.setResultado(num.getNum1() * num.getNum2());
            System.out.println("El resultado de la multiplicacion es: " + num.getResultado());

            outObjeto.writeObject(num);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
