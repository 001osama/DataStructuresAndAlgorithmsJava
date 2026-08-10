package Arrays.BinarySearchPatterns;

public class SearchOn2DMatrix {

    //74. Search a 2D Matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);

        if(row == -1) return false;

        int targetValueIndex = binarySearch(matrix[row], target);
        return  targetValueIndex != -1;
    }

    private static int binarySearch(int[] nums, int target)
    {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start<=end)
        {
            int mid = start+end>>>1;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }


    private static int searchRow(int[][] matrix, int target)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = n-1;

        while(start<=end)
        {
            int mid = start+end >>> 1;
            int[] midArray = matrix[mid];
            if(midArray[0]<=target && midArray[m-1] >= target)
                return mid;
            else if (midArray[0]<=target && midArray[m-1] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

}
