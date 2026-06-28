package Backtracking;

public class Logger {
    public static void info(Object... args) {
        for (Object s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
