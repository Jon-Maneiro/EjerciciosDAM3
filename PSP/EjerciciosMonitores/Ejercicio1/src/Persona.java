public class Persona extends Thread{
    static Banco banco = new Banco();

    private boolean tipo;

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public Persona(boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run(){
        if(tipo){
            while(true) {
                try {
                    banco.meterDinero();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            while(true) {
                try {
                    banco.gastarDinero();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
