package Arrays;

import java.util.HashMap;

public class Pointers {

    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> repo = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            int remain = target - nums[i];
            if(repo.containsKey(remain))
                return new int[]{nums[i], repo.get(remain)};
            repo.put(nums[i],i);
        }
        return new int[2];
    }

    //75. Sort Colors
    public static void sortColors(int[] nums) {
        int leftBound = 0;
        int rightBound = nums.length-1;
        int current = 0;
        while(current<=rightBound)
        {
            //dont increment pointer if the current is less than 1
            if(nums[current] > 1)
            {
                int temp = nums[rightBound];
                nums[rightBound] = nums[current];
                nums[current] = temp;
                rightBound--;
            }
            else if(nums[current] < 1)
            {
                int temp = nums[leftBound];
                nums[leftBound] = nums[current];
                nums[current] = temp;
                leftBound++;
                current++;
            }
            else
                current++;
        }

    }



    //977. Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        int[] result = new int[nums.length];

        for(int i = result.length-1; i >=0; i--)
        {
            if(Math.abs(nums[leftPointer]) < Math.abs(nums[rightPointer]))
            {
                result[i] = nums[rightPointer]*nums[rightPointer];
                rightPointer--;
            }
            else
            {
                result[i] = nums[leftPointer]*nums[leftPointer];
                leftPointer++;
            }
        }
        return result;
    }


    //88. Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstArrayPointer = m-1;
        int secondArrayPointer = n-1;
        int currentPointer = nums1.length - 1;
        while(firstArrayPointer>=0 && secondArrayPointer>=0)
        {
            if(nums1[firstArrayPointer]>=nums2[secondArrayPointer])
            {
                nums1[currentPointer] = nums1[firstArrayPointer];
                currentPointer--;
                firstArrayPointer--;
            }
            else
            {
                nums1[currentPointer] = nums2[secondArrayPointer];
                currentPointer--;
                secondArrayPointer--;
            }
        }

        while(secondArrayPointer>=0)
        {
            nums1[currentPointer] = nums2[secondArrayPointer];
            currentPointer--;
            secondArrayPointer--;
        }

    }
}
