package Arrays.BinarySearchPatterns;

public class SearchOn2DMatrix {

    //378. Kth Smallest Element in a Sorted Matrix
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = matrix[0][0];
        int end = matrix[m-1][n-1];

        while(start<=end)
        {
            int proposedTarget = start+(end-start)/2;
            if(isKthSmallest(matrix, k, proposedTarget))
                start = proposedTarget+1;
            else
                end = proposedTarget-1;
        }
        return end;
    }

    private static boolean isKthSmallest(int[][] matrix, int k, int target)
    {
        int totalCount = 0;
        for(int[] row: matrix)
        {
            int start = 0;
            int end = row.length-1;

            while(start<=end)
            {
                int mid = start+end>>>1;
                if(row[mid] >= target)
                    end = mid-1;
                else
                    start = mid+1;
            }
            totalCount+=start;
        }
        return totalCount < k;
    }

    //240. Search a 2D Matrix II
    public static boolean searchMatrixII(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;


        int rowIndex = 0;
        int colIndex = colLength-1;

        while(rowIndex < rowLength && colIndex>=0)
        {
            if(matrix[rowIndex][colIndex] == target)
                return true;
            else if (matrix[rowIndex][0]<=target && matrix[rowIndex][colIndex] > target)
                colIndex--;
            else
                rowIndex++;
        }
        return false;
    }


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
