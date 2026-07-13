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
        Arrays.sort(files);

        long totalTime = 0;
        for(int i = files.length-1; i >= 0; i--)
        {
            if(files[i] % numCores == 0 && limit > 0)
            {
                totalTime += files[i]/numCores;
                totalTime += files[i] % numCores;
                limit--;
            }
            else
                totalTime += files[i];

        }

        return totalTime;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/ParallelProcessing/TestCases";
    }
}