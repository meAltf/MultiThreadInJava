package Thread;

public class mainThreadCheck {

    public static void main(String[] args) {
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }

    /** By default, Java programs run on the "main" thread created by the JVM **/
}
