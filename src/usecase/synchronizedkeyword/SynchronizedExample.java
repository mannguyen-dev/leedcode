package usecase.synchronizedkeyword;

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::display, "T1");
        Thread t2 = new Thread(resource::display, "T2");

        t1.start();
        t2.start();
    }
}
