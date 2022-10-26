import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        ObjectOutputStream os;
        ObjectInputStream is;
        Calculadora calc;
        Scanner sc = new Scanner(System.in);

        boolean cont = true;

        try(Socket peticion = new Socket("localhost", 5666)){
            while(cont) {
                os = new ObjectOutputStream(peticion.getOutputStream());
                is = new ObjectInputStream(peticion.getInputStream());



                System.out.println("Que operacion deseas realizar.");
                System.out.println("1-suma");
                System.out.println("2-resta");
                System.out.println("3-multiplicacion");
                System.out.println("4-division");
                int operacion = Integer.parseInt(sc.nextLine());
                System.out.println("Primer operando");
                int num1 = Integer.parseInt(sc.nextLine());
                System.out.println("Segundo operando");
                int num2 = Integer.parseInt(sc.nextLine());

                calc = new Calculadora(num1,num2,operacion);

                os.writeObject(calc);

                calc = (Calculadora)is.readObject();

                System.out.println("El resultado es: " + calc.getResultado());

                System.out.println("Quieres continuar? Y/N");
                String x = sc.nextLine();
                if(x.toUpperCase() == "N"){
                    cont = false;
                }

            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
