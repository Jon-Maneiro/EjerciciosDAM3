public class Contador {
    static int contador = 0;

    synchronized void incrementar(){
        contador++;
        System.out.println("El contador esta a " + contador + " ultimo incremento efectuado por " + Thread.currentThread().getName());

    }
    synchronized void disminuir(){
        contador--;
        System.out.println("El contador esta a " + contador + " ultima disminución efectuada por " + Thread.currentThread().getName());

    }
}
