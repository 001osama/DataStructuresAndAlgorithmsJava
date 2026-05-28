// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.RoadRepair;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.Scanner;

public class RoadRepairSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n        = readInt(in);
        int[] crewId = readIntArray(in, n);

        int n2       = readInt(in);   // HackerRank repeats n before the second array
        int[] jobId  = readIntArray(in, n2);

        out.println(getMinCost(crewId, jobId));
    }

    private long getMinCost(int[] crewId, int[] jobId) {
        // your logic here
        return 0;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/RoadRepairSolution/TestCases";
    }
}