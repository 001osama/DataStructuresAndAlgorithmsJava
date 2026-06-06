import HackerRankCodeRunner.Problems.ActiveTraders.ActiveTradersSolution;
import HackerRankCodeRunner.Problems.LongestSubarray.LongestSubarraySolution;
import HackerRankCodeRunner.Problems.NearlySimilarRectangles.NearlySimilarRectanglesSolution;
import HackerRankCodeRunner.Problems.RoadRepair.RoadRepairSolution;
import HackerRankCodeRunner.Problems.StringAnagram.StringAnagramSolution;
import HackerRankCodeRunner.Problems.UnexpectedDemand.UnexpectedDemandSolution;
import HackerRankCodeRunner.TestCaseRunner;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Program working \n");

//        int result = search(new int[]{-1,0,3,5,9,12}, 9);
        try
        {
            new TestCaseRunner(new LongestSubarraySolution()).runAll();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Program ended");
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