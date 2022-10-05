public class temperaturometro extends Thread{

    static SistemaControl sc = new SistemaControl();

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(Math.random() >= 0.4){
                sc.subirTemp();
            }else{
                sc.bajarTemp();
            }
        }
    }
}
