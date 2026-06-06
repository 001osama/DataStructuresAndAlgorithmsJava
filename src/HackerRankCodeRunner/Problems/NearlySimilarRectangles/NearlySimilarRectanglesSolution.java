// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.NearlySimilarRectangles;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class NearlySimilarRectanglesSolution extends HackerRankSolution {

    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/NearlySimilarRectangles/TestCases";
    }

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n       = readInt(in);
        int cols    = readInt(in);

        long[][] sides = new long[n][cols];
        for (int i = 0; i < n; i++) {
            sides[i][0] = in.nextLong();
            sides[i][1] = in.nextLong();
            if (in.hasNextLine()) in.nextLine();
        }

        out.println(nearlySimilarRectangles(sides));
    }

    private long nearlySimilarRectangles(long[][] sides) {
        Map<Double, Integer> seen = new HashMap<>();
        int noOfSimilarRectangles = 0;
        for(long[] side:sides)
        {
            double result = (double) side[0] /side[1];
            seen.put(result, seen.getOrDefault(result,0)+1);
        }

        for(int seenTimes:seen.values())
        {
            if(seenTimes%2 == 0)
                noOfSimilarRectangles += seenTimes/2;
            else if(seenTimes > 1)
                noOfSimilarRectangles += seenTimes ;
        }

        return noOfSimilarRectangles;
    }

}