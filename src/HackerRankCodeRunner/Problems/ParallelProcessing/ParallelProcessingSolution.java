// ParallelProcessingSolution.java
package HackerRankCodeRunner.Problems.ParallelProcessing;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class ParallelProcessingSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n        = readInt(in);
        long[] files = readLongArray(in, n);   // files[i] can reach 10^9 → long

        long numCores = Long.parseLong(in.nextLine().trim());
        long limit    = Long.parseLong(in.nextLine().trim());

        out.println(minTime(files, numCores, limit));
    }

    private long[] readLongArray(Scanner in, int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(in.nextLine().trim());
        }
        return arr;
    }

    private long minTime(long[] files, long numCores, long limit) {
        // TODO: implement
        // A file executed alone       → takes files[i] time
        // A file executed in parallel → takes ceil(files[i] / numCores) time
        //                               but only ONE file at a time can use all cores
        //                               (limited by `limit` parallel slots,
        //                               though only one gets the core division benefit)
        // Goal: minimum total sequential time across all files
        return 0;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/ParallelProcessing/TestCases";
    }
}