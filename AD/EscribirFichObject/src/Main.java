import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        File fichero = new File("FichData.dat");
//
//        Persona[] personas = {new Persona("Miguel",39), new Persona("Jorge",28),
//        new Persona("Roberto",30)};
//
//
//        FileOutputStream fileout = new FileOutputStream(fichero);
//        ObjectOutputStream objtOS = new ObjectOutputStream(fileout);
//
//
//        for(int i=0; i<personas.length;i++){
//            objtOS.writeObject(personas[i]);//Insertar Persona
//        }
//
//        objtOS.close();


        File fichero = new File("FichData.dat");



        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream objIN = new ObjectInputStream(filein);
        try
        {
            while(true){
                Persona newPersona = (Persona) objIN.readObject();
                //salida.add((Persona) objIN.readObject());
                System.out.println(newPersona.toString());
            }

        }
        catch (SocketTimeoutException exc)
        {
            // you got the timeout
        }
        catch (EOFException exc)
        {
            // end of stream
        }
        catch (IOException exc)
        {
            // some other I/O error: print it, log it, etc.
            exc.printStackTrace(); // for example
        }
        objIN.close();


    }
}