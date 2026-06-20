import HackerRankCodeRunner.Problems.ActiveTraders.ActiveTradersSolution;
import HackerRankCodeRunner.Problems.LongestSubarray.LongestSubarraySolution;
import HackerRankCodeRunner.Problems.NearlySimilarRectangles.NearlySimilarRectanglesSolution;
import HackerRankCodeRunner.Problems.PasswordDecryption.PasswordDecryptionSolution;
import HackerRankCodeRunner.Problems.RoadRepair.RoadRepairSolution;
import HackerRankCodeRunner.Problems.StringAnagram.StringAnagramSolution;
import HackerRankCodeRunner.Problems.UnexpectedDemand.UnexpectedDemandSolution;
import HackerRankCodeRunner.Problems.UsernamesChanges.UsernamesChangesSolution;
import HackerRankCodeRunner.Problems.VowelSubstring.VowelSubstringSolution;
import HackerRankCodeRunner.TestCaseRunner;

import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Program working \n");


        int result3 = maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2},3);
        int result = maxOperations(new int[]{1,2,3,4},5);
        int result2 = maxOperations(new int[]{3,1,3,4,3},6);
//        try
//        {
//            new TestCaseRunner(new PasswordDecryptionSolution()).runAll();
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.print("Program ended with result: " + result);
    }



//    public static int findMaxConsecutiveOnes(int[] nums) {
//        int maxOccurences = 0;
//        int currentOccurences = 0;
//        for(int num:nums)
//        {
//            if(num == 1)
//            {
//                currentOccurences++;
//            }
//            else
//            {
//                maxOccurences = Math.max(currentOccurences, maxOccurences);
//                currentOccurences = 0;
//            }
//        }
//        maxOccurences = Math.max(currentOccurences, maxOccurences);
//        return maxOccurences;
//    }

    ////    arr=[0,1,2,1,0,1,2,3];
    private static int longestSubarray(int[] arr) {
        int maxSubArraySize = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> seen = new HashMap<>();

        while(left <= right && right < arr.length)
        {
            int noOfElementsSeen = seen.size();
            boolean isElementExists = seen.containsKey(arr[right]);
            if(isElementExists)
            {
                right++;
            }
            else if(noOfElementsSeen == 0)
            {
                seen.put(arr[right],right);
                right++;
            }
            else if(noOfElementsSeen == 2)
            {
                maxSubArraySize = Math.max(maxSubArraySize, right-left);

                int minElement = Collections.min(seen.keySet());
                left = seen.get(minElement) + 1;
                seen.remove(minElement);

                seen.put(arr[right], right);
                right++;
            }
            else
            {
                int seenElement = seen.keySet().iterator().next();
                if( Math.abs(seenElement - arr[right]) <= 1 )
                {
                    seen.put(arr[right], right);
                    right++;
                }
                else
                {
                    maxSubArraySize = Math.max(maxSubArraySize, right-left);
                    seen = new HashMap<>();
                    seen.put(arr[right], right);
                    left = right;
                    right++;
                }
            }
        }
        maxSubArraySize = Math.max(maxSubArraySize, right-left);
        return maxSubArraySize;
    }

    //704. Binary Search
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left<=right)
        {
            int middle = (right+left)/2;
            if(nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }





//    public int leastInterval(char[] tasks, int n) {
//
//    }


    //704. Binary Search
//    public int search(int[] nums, int target) {
//
//    }

//  704. Binary Search
//    public int search(int[] nums, int target) {
//
//    }
//
//    public int search(int nums[], int target, int pivotIndex)
//    {
//        if(target>nums[pivotIndex])
//            search(nums, target,pivot)
//    }


    //1456. Maximum Number of Vowels in a Substring of Given Length
    //    public int maxVowels(String s, int k) {
    //
    //    }







    //1995. Count Special Quadruplets
//    public int countQuadruplets(int[] nums) {
//
//    }






}