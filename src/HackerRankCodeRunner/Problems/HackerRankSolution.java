package HackerRankCodeRunner.Problems;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class HackerRankSolution implements IHackerRankSolution {

    public abstract String getTestCasesDirectoryPath();

    protected int readInt(Scanner in) {
        int val = in.nextInt();
        in.nextLine(); // always consume leftover newline
        return val;
    }

    protected String[] readStringArray(Scanner in, int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine().trim();
        }
        return arr;
    }

    protected int[] readIntArray(Scanner in, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        return arr;
    }

    protected void printArray(PrintWriter out, String[] arr) {
        for (String s : arr) out.println(s);
    }

    protected void printArray(PrintWriter out, int[] arr) {
        for (int x : arr) out.println(x);
    }
}