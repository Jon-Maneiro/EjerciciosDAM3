public class HiloImpar extends Thread{

    public void run(){
        for(int x = 0; x < 100; x++){
            if(x % 2 != 0){
                System.out.println(x);
            }
        }
    }
}

