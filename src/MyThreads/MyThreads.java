package MyThreads;

public class MyThreads implements Runnable {

    @Override
    public void run() {
       // System.out.println("The thread is running");
        for(int i = 0;i<5;i++){
            try {
                Thread.sleep(500);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println(i+"."+Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        MyThreads m = new MyThreads();
       // Thread th1 = new Thread(m,"This is the first thread I made");
        Thread th1 = new Thread(m);
        Thread th2 = new Thread(m);

        th1.start();
        th2.start();


       // String str = th1.getName();
       // System.out.println(str);
     //   th1.stop();
    }
}
