package usecase.racecondition;

public class MyThread extends Thread {

    SharedResource resource;

    MyThread(SharedResource res) {
        this.resource = res;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.addText("X");
        }
    }

}
