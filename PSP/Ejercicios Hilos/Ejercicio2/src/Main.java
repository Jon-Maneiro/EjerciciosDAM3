public class Main {
    public static void main(String[] args) {
        HiloPar hilopar = new HiloPar();
        HiloImpar hiloimpar = new HiloImpar();


        hilopar.setPriority(8);
        System.out.println("Prioridad Par" + hilopar.getPriority());
        System.out.println("Prioridad Impar" + hiloimpar.getPriority());
        hilopar.start();
        hiloimpar.start();


    }
}