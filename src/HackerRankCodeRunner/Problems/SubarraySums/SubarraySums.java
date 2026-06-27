// SubarraySums.java
package HackerRankCodeRunner.Problems.SubarraySums;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class SubarraySums extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n         = readInt(in);
        int[] numbers = readIntArray(in, n);   // 1-indexed in problem, stored 0-indexed here

        int q         = readInt(in);
        int querySize = readInt(in);           // always 3, must consume this line

        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine());
            queries[i][0] = Integer.parseInt(st.nextToken()); // l
            queries[i][1] = Integer.parseInt(st.nextToken()); // r
            queries[i][2] = Integer.parseInt(st.nextToken()); // x
        }

        long[] result = findSum(numbers, queries);
        for (long r : result) out.println(r);
    }

    private long[] findSum(int[] numbers, int[][] queries) {

        long[] result = new long[queries.length];
        System.out.println(Arrays.toString(numbers));
        System.out.println("\n");
        for(int i = 0; i < queries.length; i++)
        {
            int start = queries[i][0]-1;
            int end = queries[i][1]-1;
            int sumValue = queries[i][2];

            long currentSum = 0;
            for(int j = start; j <= end; j++)
            {
                if(numbers[j] == 0)
                    currentSum+=sumValue;
                else
                    currentSum+=numbers[j];
            }
            result[i] = currentSum;
        }

        return result;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/SubarraySums/TestCases";
    }

}