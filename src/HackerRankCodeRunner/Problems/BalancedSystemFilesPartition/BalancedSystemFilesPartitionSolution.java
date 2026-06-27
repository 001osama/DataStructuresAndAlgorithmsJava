// BalancedSystemFilesPartitionSolution.java
package HackerRankCodeRunner.Problems.BalancedSystemFilesPartition;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class BalancedSystemFilesPartitionSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n        = readInt(in);
        int[] parent = readIntArray(in, n);

        int m             = readInt(in);       // same n, must consume
        int[] filesSize   = readIntArray(in, m);

        out.println(mostBalancedPartition(parent, filesSize));
    }

    private int mostBalancedPartition(int[] parent, int[] filesSize) {
        // TODO: implement
        // Each node's total content size = its own filesSize
        //   + sum of total content sizes of ALL its descendants
        //
        // For each non-root node i, cutting the edge between i and parent[i]
        // produces two subtrees:
        //   - subtree rooted at i  → subtreeSize[i]
        //   - the rest             → totalSize - subtreeSize[i]
        //
        // Return the minimum |subtreeSize[i] - (totalSize - subtreeSize[i])|
        // across all valid cuts (i.e. all non-root nodes)
        return 0;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/BalancedSystemFilesPartition/TestCases";
    }

}