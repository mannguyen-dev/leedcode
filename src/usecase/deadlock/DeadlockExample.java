package usecase.deadlock;

public class DeadlockExample {
    private static final Resource resource1 = new Resource();
    private static final Resource resource2 = new Resource();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked Resource 1");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                synchronized (resource2) {
                    System.out.println("Thread 1 locked Resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 locked Resource 2");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                synchronized (resource1) {
                    System.out.println("Thread 2 locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
