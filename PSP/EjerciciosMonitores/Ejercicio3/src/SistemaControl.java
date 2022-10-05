public class SistemaControl {

    static int numPersonas = 0;
    static int temperatura = 31;

    synchronized void salir() throws InterruptedException {
        System.out.println("Ha estao bien, me voy");
        numPersonas += 1 * -1;
        if (temperatura >= 30) {
            if (numPersonas < 35) {//hay sitio
                notifyAll();
            }
        } else {
            if (numPersonas < 50) {
                notifyAll();
            }
        }
    }

    synchronized void entrar() throws InterruptedException {

        boolean heLogradoEntrar = false;
        while (!heLogradoEntrar) {//Comprobar si hay sitio o no
            if (temperatura >= 30) {
                if (numPersonas >= 35) {//No hay sitio
                    System.out.println("No hay sitio :(");
                    wait();
                } else {
                    heLogradoEntrar = true;

                }
            } else {
                if (numPersonas == 50) {
                    System.out.println("No hay sitio :(");
                    wait();
                } else {
                    heLogradoEntrar = true;

                }
            }
        }

        System.out.println("HE ENTRADO SUUUUUUUUUUUUUUUU");
        numPersonas++;


    }


    synchronized void subirTemp(){
        temperatura++;
        System.out.println("Temperatura= " + temperatura);
    }
    synchronized  void bajarTemp(){
        temperatura--;
        System.out.println("Temperatura= " + temperatura);
    }

}


