package usecase.racecondition;

public class RaceConditionOfStringBuilder {

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread t1 = new MyThread(resource);
        Thread t2 = new MyThread(resource);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(resource.sb.length()); // Expected: 2005, Actual: unpredictable!
    }

}
