public class Puente {

    static int pesoMax = 15000;
    static int pesoActual = 0;
    static int vehiculosMax = 5;
    static int vehiculosActual = 0;

    synchronized void entrarPuente(int peso) throws InterruptedException {
        boolean heLogradoEntrar = false;
        while(!heLogradoEntrar){//Comprobacion de si se puede entrar o no
            if((pesoActual + peso) > 15000){
                System.out.println("Peso demasiado para entrar actualmente");
                System.out.println("Peso actual: " + pesoActual);
                wait();
            }
            if((vehiculosActual + 1) > 5){
                System.out.println("No hay espacio para entrar");
                wait();
            }
            heLogradoEntrar = true;
        }

        pesoActual += peso;
        vehiculosActual++;
        System.out.println("Estoy cruzando el puente");


    }

    synchronized void salirPuente(int peso){
        pesoActual -= peso;
        vehiculosActual--;
        notifyAll();
    }

}
