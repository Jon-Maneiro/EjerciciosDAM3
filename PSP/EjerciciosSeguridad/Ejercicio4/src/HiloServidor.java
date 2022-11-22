import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class HiloServidor extends Thread {


    static ObjectOutputStream fSalida;
    static ObjectInputStream fEntrada;
    Socket cliente;

    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;
        // se crean los flujos de entrada y salida
        this.fSalida = new ObjectOutputStream(cliente.getOutputStream());
        this.fEntrada = new ObjectInputStream(cliente.getInputStream());
    }

    @Override
    public void run() {

        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
            KeyPair keypair = keygen.generateKeyPair();

            fSalida.writeObject(keypair.getPublic());

            Cipher rsaCipher = Cipher.getInstance("RSA");
            rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPrivate());
            String mensaje = new String(fEntrada.readAllBytes());
            System.out.println("Mensaje Cifrado: "+ mensaje);
            String mensajeDescifrado = String.valueOf(rsaCipher.doFinal(mensaje.getBytes()));

            System.out.println("Mensaje Descifrado:" + mensajeDescifrado);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }
}
