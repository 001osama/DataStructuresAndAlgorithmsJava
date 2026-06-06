// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.UnexpectedDemand;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class UnexpectedDemandSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n        = readInt(in);
        int[] orders = readIntArray(in, n);
        int k        = readInt(in);          // k comes AFTER the n order lines

        out.println(filledOrders(orders, k));
    }

    private int filledOrders(int[] order, int k) {
        Arrays.sort(order);
        int ordersFulfilled = 0;
        for(int i = 0; i < order.length; i++)
        {
            if(k>=order[i])
            {
                k = k-order[i];
                ordersFulfilled++;
            }
        }
        return ordersFulfilled;
    }





    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/UnexpectedDemand/TestCases";
    }

}