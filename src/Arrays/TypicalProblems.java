package Arrays;

import java.util.Arrays;
import java.util.List;

public class TypicalProblems {


    //1431. Kids With the Greatest Number of Candies
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        Boolean[] result = new Boolean[candies.length];
        for(int i = 0; i < candies.length; i++)
            maxCandies = Math.max(candies[i], maxCandies);

        for(int i = 0; i < candies.length; i++)
            result[i] = candies[i] + extraCandies >= maxCandies;

        return Arrays.asList(result);
    }

    //1470. Shuffle the Array
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index1 = 0;
        int index2 = n;
        int currentIndex = 0;
        while(index2 < nums.length)
        {
            result[currentIndex++] = nums[index1++];
            result[currentIndex++] = nums[index2++];
        }
        return result;
    }

    //1071. Greatest Common Divisor of Strings
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2+str1))
            return "";

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0,gcd);
    }

    private int gcd(int len1, int len2)
    {
        while(len2 != 0)
        {
            int temp = len1 % len2;
            len1 = len2;
            len2 = temp;
        }
        return len1;
    }


    public int maximumWealth(int[][] accounts) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < accounts.length; i++)
        {
            int currentAccountSum = 0;
            for(int j = 0; j < accounts[i].length; j++)
                currentAccountSum+=accounts[i][j];

            result = Math.max(currentAccountSum, result);
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }

    //169. Majority Element
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int seen = 0;
        for(int num:nums)
        {
            if(seen==0)
                candidate = num;

            if(candidate == num)
                seen++;
            else
                seen--;
        }
        return candidate;
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
}
