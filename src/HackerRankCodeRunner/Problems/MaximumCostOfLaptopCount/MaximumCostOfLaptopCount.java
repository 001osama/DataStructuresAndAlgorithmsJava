// MaximumCostOfLaptopCount.java
package HackerRankCodeRunner.Problems.MaximumCostOfLaptopCount;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class MaximumCostOfLaptopCount extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n          = readInt(in);
        int[] cost     = readIntArray(in, n);

        int m          = readInt(in);        // same n, but read again per input format
        String[] labels = readStringArray(in, m);

        int dailyCount = readInt(in);

        out.println(maxCost(cost, labels, dailyCount));
    }

    private int maxCost(int[] cost, String[] labels, int dailyCount) {

        int result = 0;
        int currentCost = 0;
        int currentDays = 0;
        for(int i = 0; i < cost.length; i++)
        {
            currentCost += cost[i];
            if(Objects.equals(labels[i], "legal"))
                currentDays++;

            if(dailyCount == currentDays)
            {
                result = Math.max(result, currentCost);
                currentCost=0;
                currentDays=0;
            }
        }
        return result;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/MaximumCostOfLaptopCount/TestCases";
    }

}