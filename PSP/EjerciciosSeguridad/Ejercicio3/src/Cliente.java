import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    public static void main(String[] args) {
        try
        {
            // PASO 1: Crear claves AES
            System.out.println("Obteniendo generador de claves con cifrado AES");
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            System.out.println("Generando clave");
            keygen.init(128);//definimos tamaño de clave de 128 bits
            SecretKey key = keygen.generateKey();
            System.out.println(key);
            // PASO 2: Crear cifrador AES
            System.out.println("Obteniendo objeto Cipher con cifraddo AES");
            Cipher desCipher = Cipher.getInstance("AES");
            // PASO 3a: Poner cifrador en modo CIFRADO
            System.out.println("Configurando Cipher para encriptar");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("Preparando Mensaje");
            System.out.println("Cifrando mensaje");
            // CIFRADO
            byte textoPlano[]="Preparando terreno para encriptar EN AES".getBytes();
            byte textoCifrado[]= desCipher.doFinal(textoPlano);

            String mensajeCifrado = new String(textoCifrado);

            System.out.println("Mensaje Cifrado: " + mensajeCifrado);
            // PASO 3b: Poner cifrador en modo DESCIFRADO
            System.out.println("Configurando Cipher para desencriptar");
            desCipher.init(Cipher.DECRYPT_MODE, key);
            System.out.println("Descifrando mensaje");
            // DESCIFRADO
            byte desencriptado[]=desCipher.doFinal(textoCifrado);
            String mensajeDescifrado = new String(desencriptado);
            System.out.println("Mensaje Descifrado: " + mensajeDescifrado);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        PrintWriter fSalida;
        BufferedReader fEntrada;
        Scanner sc  =new Scanner(System.in);

        try (Socket peticion = new Socket("localhost", 6000)) {

            System.out.println("OIAFOang");

            fSalida = new PrintWriter(peticion.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(peticion.getInputStream()));

            fSalida.println(sc.nextLine());

            System.out.println("El texto recibido es: " + fEntrada.readLine());
            //Math.floor(Math.random() * max);


            fSalida.close();
            fEntrada.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
