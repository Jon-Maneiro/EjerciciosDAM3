import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        System.out.println("1 Para Thread 2 para Runnable");
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();

        if(num == "1"){
            String tx1,tx2,tx3;

            System.out.println("Introduce el primer texto");
            tx1 = myObj.nextLine();  // Read user input

            System.out.println("Introduce el segundo texto");
            tx2 = myObj.nextLine();

            System.out.println("Introduce el tercer texto");
            tx3 = myObj.nextLine();
            class Hilo1 extends Thread{
                private String texto;

                public Hilo1(String texto) {
                    this.texto = texto;
                }

                public void run() {
                    for(int x = 0; x < 10; x++){
                        System.out.println(this.texto);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            //Declaracion de Hilos////////////////////////////////////
            Hilo1 primerhilo = new Hilo1(tx1);
            Hilo1 segundohilo = new Hilo1(tx2);
            Hilo1 tercerhilo = new Hilo1(tx3);
            //Input de Texto////////////////////////////////////////////////////
            primerhilo.start();
            System.out.println("Se ha creado el primer hilo");

            segundohilo.start();
            System.out.println("Se ha creado el segundo hilo");

            tercerhilo.start();
            System.out.println("Se ha creado el tercer hilo");

        }
        else{
            class Runable2 implements Runnable {
                private String texto;

                public Runable2(String texto) {
                    this.texto = texto;
                }
                @Override
                public void run() {
                    for(int x = 0; x < 10; x++){
                        System.out.println(this.texto);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            String tx1,tx2,tx3;

            System.out.println("Introduce el primer texto");
            tx1 = myObj.nextLine();  // Read user input

            System.out.println("Introduce el segundo texto");
            tx2 = myObj.nextLine();

            System.out.println("Introduce el tercer texto");
            tx3 = myObj.nextLine();

            //Declaracion de Hilos////////////////////////////////////
            Runable2 primerhilo = new Runable2(tx1);
            Runable2 segundohilo = new Runable2(tx2);
            Runable2 tercerhilo = new Runable2(tx3);

            //Declarar el Thread////////////////////////////////////////
            Thread hilo1run = new Thread(primerhilo);
            Thread hilo2run = new Thread(segundohilo);
            Thread hilo3run = new Thread(tercerhilo);
            //Input de Texto////////////////////////////////////////////////////

            hilo1run.start();
            System.out.println("Se ha creado el primer hilo");

            hilo2run.start();
            System.out.println("Se ha creado el segundo hilo");

            hilo3run.start();
            System.out.println("Se ha creado el tercer hilo");

        }



    }
}