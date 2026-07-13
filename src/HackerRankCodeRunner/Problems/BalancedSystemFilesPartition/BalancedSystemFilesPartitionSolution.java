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

    // Store subtree sizes globally (like Python's size_sums array)
    private int[] sizeSums;
    private List<List<Integer>> children;
    private int[] filesSize;

    public int mostBalancedPartition(int[] parent, int[] filesSize) {
        int n = parent.length;
        this.filesSize = filesSize;
        this.sizeSums = new int[n];

        // Step 1: Build children list
        // Python: children = [[] for _ in range(n)]
        children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        // Python: for i in range(1, n): children[parent[i]].append(i)
        for (int i = 1; i < n; i++) {          // start from 1, skip root
            children.get(parent[i]).add(i);
        }

        // Step 2: Calculate all subtree sizes using DFS
        // Python: size_sums_rec(0)
        sizeSumsRec(0);

        // Step 3: Find minimum difference
        // Python: return min(abs(size_sums[0] - 2 * ss) for ss in size_sums[1:])
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {          // start from 1, skip root
            int diff = Math.abs(sizeSums[0] - 2 * sizeSums[i]);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // Python: def size_sums_rec(i):
    private int sizeSumsRec(int i) {
        // Python: size_sums[i] = files_size[i] + sum(size_sums_rec(c) for c in children[i])
        sizeSums[i] = filesSize[i];            // start with own files
        for (int child : children.get(i)) {
            sizeSums[i] += sizeSumsRec(child); // add each child's total
        }
        return sizeSums[i];                    // return so parent can add it
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/BalancedSystemFilesPartition/TestCases";
    }

}