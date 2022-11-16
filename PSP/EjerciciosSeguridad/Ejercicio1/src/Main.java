import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern patMat = Pattern.compile("^[0-9]{4}-[A-Z]{3}$");
        Matcher matMat;
        System.out.println("Introduce una matricula -- CuatroDigitos, guion, y tres letras mayusculas");

        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        String matri = "";
        while(!correcto){
            matri = sc.nextLine();
            matMat = patMat.matcher(matri);
            boolean matchFoundMat = matMat.find();
            if(!matchFoundMat){
                System.out.println("Parece que no es correcto, prueba de nuevo");
            }else{
                correcto = true;
            }

        }
    }
}