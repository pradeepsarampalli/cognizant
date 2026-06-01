class MyThread1 extends Thread{
    public void run(){
        for(int i=0; i<50; i++){
            System.out.println("Thread1 is running --"+ i);
        }
    }
}
class MyThread2 implements Runnable{
    public void run(){
        for(int i=0; i<50; i++){
            System.out.println("Thread2 is running --"+ i);
        }
    }
}
public class Threads {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();

        Runnable r = new MyThread2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        //no threads behaviour
        // t1.run();
        // t2.run();
    }
}