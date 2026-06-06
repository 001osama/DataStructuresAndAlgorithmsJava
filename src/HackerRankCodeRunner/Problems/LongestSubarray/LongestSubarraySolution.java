// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.LongestSubarray;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class LongestSubarraySolution extends HackerRankSolution {

    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/LongestSubarray/TestCases";
    }

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n      = readInt(in);
        int[] arr  = readIntArray(in, n);

        out.println(longestSubarray(arr));
    }

//    arr=[0,1,2,1,2,3];
    private int longestSubarray(int[] arr) {
        int subArraySize = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        while(left <= right && right < arr.length)
        {
            if(seen.size() > 1 && !seen.containsKey(arr[right]))
            {
                subArraySize = Math.max(subArraySize, right-left);
                while(seen.size() > 1)
                {
                    int numberOfTimesSeen = seen.get(arr[left]);
                    numberOfTimesSeen--;

                    if(numberOfTimesSeen==0)
                        seen.remove(arr[left]);
                    else
                        seen.put(arr[left],numberOfTimesSeen);

                    left++;
                }
            }

            seen.put(arr[right], seen.getOrDefault(arr[right],0)+1);
            right++;
        }
        subArraySize = Math.max(subArraySize, right-left);
        return subArraySize;
    }

//    private int longestSubarray(int[] arr) {
//
//    }
}