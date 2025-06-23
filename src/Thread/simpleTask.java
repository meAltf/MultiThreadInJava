package Thread;

public class simpleTask {
    public static void main(String[] args) {
        printNumbers();
        printLetters();
    }

    static void printNumbers() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("Number: " + i);
        }
    }

    static void printLetters() {
        for (char c = 'A'; c <= 'B'; c++) {
            System.out.println("Letter: " + c);
        }
    }
}
