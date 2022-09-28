public class Ninno extends Thread {
    static Caja caja = new Caja();

    Ninno() {
    }

    @Override
    public void run() {
        boolean eee = true;
        while (eee) {
            if(caja.getJuguetes() > 0) {
                try {
                    caja.getSemaforo().acquire();
                    caja.sacarJuguete();
                    System.out.println("UN JUGUETE MAS PARA LA HOGUERA!!!!!!!!!");
                    eee = false;
                    caja.getSemaforo().release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}

