package Arrays;

public class PrefixSum {

    //238. Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {
        int[] suffixProduct = new int[nums.length];
        int[] result = new int[nums.length];
        int currentPrefix = 1;

        suffixProduct[nums.length - 1] = 1;

        for(int i = nums.length - 2; i>=0; i--)
            suffixProduct[i]=nums[i+1]*suffixProduct[i+1];

        //[12,12,4,1]
        for(int i = 0; i < nums.length; i++)
        {
            result[i] = suffixProduct[i]*currentPrefix;
            currentPrefix *= nums[i];
        }

        return result;
    }

    //238. Product of Array Except Self
    public static int[] productExceptSelfSpaceOptimized(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int[] result = new int[nums.length];

        result[0] = 1;
        for(int i = 0; i < nums.length; i++)
        {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for(int i = nums.length-1; i >= 0; i--)
        {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

}
