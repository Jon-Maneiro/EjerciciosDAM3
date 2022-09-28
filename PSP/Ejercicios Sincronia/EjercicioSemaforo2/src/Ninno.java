public class Ninno extends Thread {
    static Caja caja = new Caja();

    Ninno() {
    }

    @Override
    public void run() {
        boolean eee = true;
        while (eee) {

            try {
                if (caja.getJuguetes() > 0) {
                    caja.getSemaforo().acquire();
                    if (caja.getJuguetes() > 0) {
                        caja.sacarJuguete();
                        System.out.println("UN JUGUETE MAS PARA LA HOGUERA!!!!!!!!!");
                        //eee = false;
                    } else {
                        System.out.println("PROFESOOOOOOR QUE NO HAY JUGUETES");
                    }
                    caja.getSemaforo().release();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}

