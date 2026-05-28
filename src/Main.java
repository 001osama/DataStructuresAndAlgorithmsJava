import HackerRankCodeRunner.Problems.ActiveTraders.ActiveTradersSolution;
import HackerRankCodeRunner.TestCaseRunner;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Program working");

        try
        {
            new TestCaseRunner(new ActiveTradersSolution()).runAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Program ended");
        //var result = lemonadeChange(new int []{5,5,5,10,20});
        //var resull2 = reverseWords("the sky is blue");
        //sortColors(new int []{2,0,2,1,1,0});
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