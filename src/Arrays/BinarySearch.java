package Arrays;

public class BinarySearch {

    //1351. Count Negative Numbers in a Sorted Matrix
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] row:grid)
            count+=countNegatives(row);
        return count;
    }

    public static int countNegatives(int[] row)
    {
        int start = 0;
        int n = row.length;
        int end = n-1;

        while(start <= end)
        {
            int mid = (start+end)>>>1;
            if(row[mid]>=0)
                start = mid+1;
            else
                end= mid-1;
        }

        return n-start;
    }

    //69. Sqrt(x)
    public static int mySqrt(int x) {
        if(x<=1) return x;
        int start = 0;
        int end = x;

        while(start <= end)
        {
            int mid = (start+end)>>>1;
            long squared = (long) mid *mid;

            if(squared == x) return mid;
            else if(squared < x) start = mid+1;
            else end = mid-1;
        }
        return start-1;
    }


    //367. Valid Perfect Square
    public static boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;

        while(start <= end)
        {
            int mid = (start+end)>>>1;
            long squared = (long)mid*mid;
            if(squared == num) return true;
            else if (squared < num) start = mid+1;
            else end = mid-1;
        }
        return false;
    }

    //275. H-Index II
    public static int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length-1;
        int result = 0;
        while(start <= end)
        {
            int mid = (start+end)>>>1;
            int remainingElementsAhead = citations.length - mid;
            if(citations[mid] >= remainingElementsAhead)
            {
                result = remainingElementsAhead;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return result;
    }


    //2529. Maximum Count of Positive Integer and Negative Integer
    public static int maximumCount(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int n = nums.length;

        while(start <= end)
        {
            int mid = (start+end)>>>1;
            if(nums[mid] < 0)
                start = mid+1;
            else
                end = mid-1;
        }

        int negCount = start;

        start = 0;
        end = nums.length-1;
        while(start <= end)
        {
            int mid = (start+end)>>>1;
            if(nums[mid] <= 0)
                start = mid+1;
            else
                end = mid-1;
        }

        int posCount = n-start;
        return Math.max(negCount, posCount);
    }


    //34. Find First and Last Position of Element in Sorted Array
    public static int[] searchRange(int[] nums, int target) {
        int upperBound = -1;
        int lowerBound = -1;

        int start = 0;
        int end = nums.length-1;
        while(start <= end)
        {
            int mid = (start + end) >>> 1;
            if(nums[mid] > target)
                end = mid-1;
            else if(nums[mid] < target)
                start = mid+1;
            else
            {
                upperBound = mid;
                end = mid-1;
            }
        }


        start = 0;
        end = nums.length-1;
        while(start <= end)
        {
            int mid = (start + end) >>> 1;
            if(nums[mid] > target)
                end = mid-1;
            else if(nums[mid] < target)
                start = mid+1;
            else
            {
                lowerBound = mid;
                start = mid+1;
            }
        }


        return new int[]{upperBound,lowerBound};
    }

    //153. Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        int start = 0;
        int n = nums.length;
        int end = n-1;

        while(start < end)
        {
            int mid = (start+end)>>>1;
            if(nums[mid] >nums[end])
                start = mid+1;
            else
                end = mid;
        }

        return nums[end];
    }
}
