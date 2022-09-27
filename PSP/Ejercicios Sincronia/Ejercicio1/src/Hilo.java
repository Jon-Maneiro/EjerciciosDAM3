public class Hilo  extends Thread{
    Thread hilo;
    static sumArray sumarray = new sumArray();
    int a[];
    int resp;

    Hilo(String nombre, int nums[]){
        hilo = new Thread(this, nombre);
        a = nums;
    }


    @Override
    public void run() {
        int sum;
        System.out.println(hilo.getName()+ " iniciando.");
        resp=sumarray.sumArray(a);
        System.out.println("Suma para "+hilo.getName()+ " es "+resp);
        System.out.println(hilo.getName()+ " terminado.");
    }
}
