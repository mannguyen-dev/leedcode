package usecase.deadlock;

public class Resource {
    public void use() {
        System.out.println(Thread.currentThread().getName() + " is using resource.");
    }
}
