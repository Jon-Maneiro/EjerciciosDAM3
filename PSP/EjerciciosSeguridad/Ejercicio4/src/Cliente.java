import javax.crypto.*;
import java.io.*;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream fSalida;
        ObjectInputStream fEntrada;
        Scanner sc = new Scanner(System.in);

        try(Socket peticion = new Socket("localhost", 6009)) {
            fSalida = new ObjectOutputStream(peticion.getOutputStream());
            fEntrada = new ObjectInputStream(peticion.getInputStream());

            PublicKey key = (PublicKey) fEntrada.readObject();

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String mensaje = "";
            do {
                System.out.println("Introduce el mensaje que deseas enviar");
                mensaje = sc.nextLine();
                fSalida.writeBytes(String.valueOf(cipher.doFinal(mensaje.getBytes())));
            }while(mensaje != "salir");


        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}
