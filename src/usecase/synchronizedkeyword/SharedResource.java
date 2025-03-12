package usecase.synchronizedkeyword;

public class SharedResource {
    public synchronized void display() {  // Lock on 'this'
        System.out.println("Thread " + Thread.currentThread().getName() + " is executing.");
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
    }
}
