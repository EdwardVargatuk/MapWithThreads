
public class MainClass {
    public static void main(String[] args) {


 Three three = new Three();
        Producer producer =new Producer(three, 10);
 Consumer consumer =new Consumer(three, 10);
Producer producer1 = new Producer(three, 10);
        Consumer consumer1 =new Consumer(three, 10);
        Long before = System.currentTimeMillis();
        Runnable runnable = () -> {
            new Thread(producer).start();

            new Thread(consumer).start();
            new Thread(producer1).start();
            new Thread(consumer1).start();
        };

        Thread myThread = new Thread(runnable);

        myThread.start();
        Long after = System.currentTimeMillis();
        System.out.println(after-before);
    }
}