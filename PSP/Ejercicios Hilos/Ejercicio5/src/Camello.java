public class Camello extends Thread{
    private String nombre;
    public Camello(String nombre) {
        this.nombre = nombre;
    }
    public void run(){
        int numeroAleatorio;
        int x = 0;
        while(x < 100){
            numeroAleatorio = (int) (Math.random()*10+1);
            x += numeroAleatorio;
            //System.out.println(nombre + " esta en la posicion " + x);
        }
        System.out.println("El camello " + nombre + " ha llegado a la meta");
    }
}
