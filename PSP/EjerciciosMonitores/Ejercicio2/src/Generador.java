import java.util.ArrayList;

public class Generador {

    static ArrayList<Integer> nums = new ArrayList<Integer>();

    synchronized void generarNum() throws InterruptedException {
        while (nums.size() == 20) {
            System.out.println("Esta lleno >:(");
            wait();
        }
        nums.add((int) Math.floor(Math.random() * 10));
        notifyAll();
    }

    synchronized void sacarNum() throws InterruptedException {
        while(nums.size() == 0){
            System.out.println("No quedan numeros que sacar, ayuda ahhhhhhh");
            wait();
        }
        System.out.println(nums.get(0));
        nums.remove(0);
        notifyAll();
    }

}
