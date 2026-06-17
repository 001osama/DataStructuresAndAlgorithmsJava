// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.LongestSubarray;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.sql.Array;
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

    //    arr=[0,1,2,1,0,1,2,3];
    private int longestSubarray(int[] arr) {
        int maxSubArrSize = 0;

        for(int i = 0; i < arr.length; i++)
        {
            Set<Integer> seen= new HashSet<Integer>();

            int j = i-1;
            while(++j < arr.length)
            {
                if(seen.contains(arr[j]))
                    continue;

                if(seen.isEmpty())
                    seen.add(arr[j]);
                else if(seen.size() == 1)
                {
                    int firstValue = seen.iterator().next();
                    if(Math.abs(firstValue - arr[j]) == 1)
                        seen.add(arr[j]);
                    else
                        break;
                }
                else
                    break;
            }
            maxSubArrSize = Math.max(maxSubArrSize, j-i);
        }
        return maxSubArrSize;
    }
//    arr=[0,1,2,1,0,1,2,3];
//    private int longestSubarray(int[] arr) {
//        int maxSubArraySize = 0;
//        int left = 0;
//        int right = 0;
//        Map<Integer, Integer> seen = new HashMap<>();
//
//        while(left <= right && right < arr.length)
//        {
//            int noOfElementsSeen = seen.size();
//            boolean isElementExists = seen.containsKey(arr[right]);
//            if(isElementExists)
//            {
//                right++;
//            }
//            else if(noOfElementsSeen == 0)
//            {
//                seen.put(arr[right],right);
//                right++;
//            }
//            else if(noOfElementsSeen == 2)
//            {
//                maxSubArraySize = Math.max(maxSubArraySize, right-left);
//                int incompatibleElements = 0;
////                for(var element: )
//
//                Iterator<Map.Entry<Integer, Integer>> iterator = seen.entrySet().iterator();
//                while(iterator.hasNext())
//                {
//                    var entry = iterator.next();
//                    int currentDifference = Math.abs(entry.getKey() - arr[right]);
//                    if(currentDifference != 1)
//                    {
//                        seen.remove(entry.getKey());
//                        left = entry.getValue() + 1;
//                    }
//                }
//                seen.put(arr[right], right);
//                right++;
//            }
//            else
//            {
//                int seenElement = seen.keySet().iterator().next();
//                if( Math.abs(seenElement - arr[right]) <= 1 )
//                {
//                    seen.put(arr[right], right);
//                    right++;
//                }
//                else
//                {
//                    maxSubArraySize = Math.max(maxSubArraySize, right-left);
//                    seen = new HashMap<>();
//                    seen.put(arr[right], right);
//                    left = right;
//                    right++;
//                }
//            }
//        }
//        maxSubArraySize = Math.max(maxSubArraySize, right-left);
//        return maxSubArraySize;
//    }

}