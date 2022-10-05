public class Persona extends Thread {

    static Generador gen = new Generador();

    private boolean tipo;

    public Persona(boolean tipo) {
        this.tipo = tipo;
    }


    @Override
    public void run() {
        if (tipo) {
            while (true) {
                try {
                    Thread.sleep((long) Math.floor(Math.random() * 750));
                    gen.generarNum();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            while (true) {
                try {
                    Thread.sleep((long) Math.floor(Math.random() * 1000));
                    gen.sacarNum();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
