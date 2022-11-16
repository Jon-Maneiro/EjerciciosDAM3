import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        //File file = new File("Log.log");
        String matchEmail = "^[a-zA-Z]+@[a-zA-Z]+[.][a-zA-Z]{3}$";
        String matchfich = "^[a-zA-Z0-9]{1,8}$";
        Logger logger = Logger.getLogger("miLog");
        FileHandler fh = new FileHandler("Log.log",true);
        logger.setUseParentHandlers(true);
        SimpleFormatter formato = new SimpleFormatter();
        fh.setFormatter(formato);
        logger.setLevel(Level.ALL);
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce email");

        String email = sc.nextLine();

        if(email.matches(matchEmail)){
            logger.log(Level.INFO,"Se ha accedido con el correo:" + email);
            System.out.println("Introduce el nombre del fichero que deseas visualizar");
            String fich = sc.nextLine();
            if(fich.matches(matchfich)){
                logger.log(Level.INFO,"A wachin, lo encontraste");
            }else{
                logger.log(Level.WARNING,"No existe ese fichero, o no coincide el patron");
            }
        }else{
            logger.log(Level.WARNING,"Ha ocurrido un error al introducir el usuario");
        }

    }
}