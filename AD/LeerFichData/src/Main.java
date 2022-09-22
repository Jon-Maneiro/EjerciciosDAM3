import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
public class Main {


        public static void main(String[] args) throws IOException {
//            File fichero = new File("FichData.dat");
//            FileOutputStream fileout = new FileOutputStream(fichero);
//            DataOutputStream dataOS = new DataOutputStream(fileout);
//            String nombres[] = {"Ana","Luis, Miguel","Alicia","Pedro","Manuel","Andrés",
//                    "Julio","Antonio","María Jesús"};
//            int edades[] = {14,15,13,15,16,12,16,14,13};
//            for (int i=0;i<edades.length; i++){
//                dataOS.writeUTF(nombres[i]); //inserta nombre
//                dataOS.writeInt(edades[i]); //inserta edad
//            }
//            dataOS.close(); //cerrar stream

            File fichero = new File("FichData.dat");
            FileInputStream filein = new FileInputStream(fichero);
            DataInputStream dataIS = new DataInputStream(filein);
            ArrayList<String> nombres = new ArrayList<String>();
            ArrayList<Integer> edades = new ArrayList<Integer>();

            while(dataIS.available() > 0){
                nombres.add(dataIS.readUTF());
                edades.add(dataIS.readInt());
            }
            filein.close();
            System.out.println(nombres);
            System.out.println(edades);

        }
    }
