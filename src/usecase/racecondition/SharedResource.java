package usecase.racecondition;

public class SharedResource {

    StringBuilder sb = new StringBuilder("Hello"); // will make race condition
    // StringBuffer sb = new StringBuffer("Hello"); // use this instead

    void addText(String text) {
        sb.append(text); // Not thread-safe!
    }

}
