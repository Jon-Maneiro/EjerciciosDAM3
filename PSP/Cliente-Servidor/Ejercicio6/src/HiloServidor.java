import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{

    private static ObjectOutputStream os;
    private static ObjectInputStream is;

    Socket cliente;

    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;

        this.os = new ObjectOutputStream(cliente.getOutputStream());
        this.is = new ObjectInputStream(cliente.getInputStream());
    }

    @Override
    public void run(){
        try{
            System.out.println("Conectado al servidor");
            Calculadora calc = (Calculadora)is.readObject();

            System.out.println("Operando...");

            switch(calc.getOperacion()){
                case 1:
                    calc.setResultado(calc.getNum1() + calc.getNum2());
                    break;
                case 2:
                    calc.setResultado(calc.getNum1() - calc.getNum2());
                    break;
                case 3:
                    calc.setResultado(calc.getNum1() * calc.getNum2());
                    break;
                case 4:
                    calc.setResultado(calc.getNum1() / calc.getNum2());
                    break;
            }

            os.writeObject(calc);
            System.out.println("devolvida informacion, resutado = " + calc.getResultado());

            is.close();
            os.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
