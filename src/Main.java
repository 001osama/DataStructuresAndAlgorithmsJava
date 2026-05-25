import java.time.Clock;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Program working");

        //var result = lemonadeChange(new int []{5,5,5,10,20});
        //var resull2 = lemonadeChange(new int []{5,5,10,10,20});
        //var resull3 = lemonadeChange(new int []{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5});

    }


//    public int search(int[] nums, int target) {
//
//    }

















    //933. Number of Recent Calls
    class RecentCounter {
        Queue<Integer> repo;

        public RecentCounter() {
            repo = new LinkedList<>();
        }

        public int ping(int t) {
            while(repo.size() > 0 && repo.peek() > t - 3000)
                repo.poll();

            repo.offer(t);
            return repo.size();
        }
    }

    //334. Increasing Triplet Subsequence
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for(int num:nums)
        {
            if(num1>=num)
                num1 = num;
            else if(num2 >= num)
                num2 = num;
            else
                return true;
        }

        return false;
    }

    //1456. Maximum Number of Vowels in a Substring of Given Length
//    public int maxVowels(String s, int k) {
//
//    }

    //414. Third Maximum Number
    public static int thirdMax(int[] nums) {
        long firstMax=Long.MIN_VALUE;
        long secondMax=Long.MIN_VALUE;
        long thirdMax=Long.MIN_VALUE;

        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] > firstMax)
            {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] < firstMax && nums[i] > secondMax)
            {
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else if (nums[i] < secondMax && nums[i] >= thirdMax)
            {
                thirdMax = nums[i];
            }
        }
        return (int) (thirdMax != Long.MIN_VALUE ? thirdMax : firstMax);
    }





    //1995. Count Special Quadruplets
//    public int countQuadruplets(int[] nums) {
//
//    }






}