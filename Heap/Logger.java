package Heap;

import java.util.Arrays;

public class Logger {
    public static void info(Object... args) {
        for (Object s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void info(int[]... args) {
        System.out.println(Arrays.deepToString(args));
    }
}
