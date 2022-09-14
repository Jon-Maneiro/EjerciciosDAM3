import java.io.File;

public class Main {
    public static void main(String[] args) {



/*        ProcessBuilder pB=new ProcessBuilder("notepad.exe");
        File space = new File("C:");
        space.getTotalSpace();
        java.util.Map<String,String> env=pB.environment();
        System.out.println(env.entrySet());
        System.out.println("Memoria disponible en JVM:"+ env.get("FREE MEMORY"));//
        System.out.println("Memoria total de JVM:"+ env.get("TOTAL MEMORY"));
        System.out.println("Numero de procesadores:"+ env.get("NUMBER_OF_PROCESSORS"));
        System.out.println("Maxima memoria:"+ env.get("HOMEDRIVE"));*/

        System.out.println("Memoria disponible en JVM:"+ Runtime.getRuntime().freeMemory());//
        System.out.println("Memoria total de JVM:"+ Runtime.getRuntime().totalMemory());
        System.out.println("Numero de procesadores:"+ Runtime.getRuntime().availableProcessors());
        System.out.println("Maxima memoria:"+ Runtime.getRuntime().maxMemory());

    }
}