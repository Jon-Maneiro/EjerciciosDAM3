
public class Hilo extends Thread{
    private String nombre;
    public Global global;
    public Hilo(String nombre, Global global){
        this.nombre = nombre;
        this.global = global;
    }

    public void run(){
        while(global.contador < 5000){
            global.contador++;
            System.out.println(nombre + " num " + global.contador);
        }
    }
}
