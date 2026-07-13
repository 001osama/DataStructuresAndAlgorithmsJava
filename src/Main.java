import HackerRankCodeRunner.Problems.ActiveTraders.ActiveTradersSolution;
import HackerRankCodeRunner.Problems.BalancedSystemFilesPartition.BalancedSystemFilesPartitionSolution;
import HackerRankCodeRunner.Problems.LongestSubarray.LongestSubarraySolution;
import HackerRankCodeRunner.Problems.MaximumCostOfLaptopCount.MaximumCostOfLaptopCount;
import HackerRankCodeRunner.Problems.NearlySimilarRectangles.NearlySimilarRectanglesSolution;
import HackerRankCodeRunner.Problems.ParallelProcessing.ParallelProcessingSolution;
import HackerRankCodeRunner.Problems.PasswordDecryption.PasswordDecryptionSolution;
import HackerRankCodeRunner.Problems.RoadRepair.RoadRepairSolution;
import HackerRankCodeRunner.Problems.StringAnagram.StringAnagramSolution;
import HackerRankCodeRunner.Problems.SubarraySums.SubarraySums;
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

        int[]arr1 = new int[]{1,3,5,6};
        int[] arr2 = new int[]{1,3,5,6};
        int[] arr3 = new int[]{1,3,5,6};

//        int result6 = findMin(new int[]{3,4,5,1,2}); //3
//        int result5 = findMin(new int[]{4,5,6,7,0,1,2}); //3
//        int result4 = findMin(new int[]{11,13,15,17}); //3
//        int result7 = hIndex(new int[]{0}); //3
//        int result8 = hIndex(new int[]{1,2,100}); //3


//        try
//        {
//            new TestCaseRunner(new BalancedSystemFilesPartitionSolution()).runAll();
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.print("Program ended with result: ");
        System.out.print("Program ended with result: ");
    }





    public List<Integer> targetIndices(int[] nums, int target) {
        int smallerNumbers = 0;
        int equalNumbers = 0;

        for(int num:nums)
        {
            if(num < target) smallerNumbers++;
            if(num == target) equalNumbers++;
        }

        List<Integer> result = new ArrayList<>();
        while(equalNumbers-->0)
            result.add(smallerNumbers++);

        return result;
    }







    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int targetValue = target - 'a';
        char result = letters[0];
        while(start <= end)
        {
            int mid = (start + end) >>> 1;
            int charValue = letters[mid] - 'a';
            if(charValue > targetValue)
            {
                result = letters[mid];
                end = mid-1;
            }
            else if(charValue <= targetValue)
                start = mid+1;
        }
        return result;
    }

//    public static boolean isPerfectSquare(int num) {
//        if(num<=1) return true;
//        int start = 0;
//        int end = num;
//
//        while(start <= end)
//        {
//            int middle = start + (end-start)/2;
//            long squaredValue = (long)middle*middle;
//            if(squaredValue == num) return true;
//            else if(squaredValue < num) start = middle + 1;
//            else end = middle-1;
//        }
//        return false;
//    }


//    public static int mySqrt(int x) {
//        int start = 1;
//        int end = x/2;
//        int ans = 1;
//        while(start < end)
//        {
//            int middle = start + (end-start)/2;
//            long squared = (long) middle * middle;
//            if(squared <= x)
//            {
//                start = middle + 1;
//            }
//            else
//                end = middle - 1;
//        }
//        return start;
//    }


    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start<=end)
        {
            int middle = (start+end)/2;
            if(nums[middle] > target)
                end = middle-1;
            else if (nums[middle] < target)
                start = middle+1;
            else
                return middle;
        }
        return start;
    }


    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start<=end)
        {
            int middle = start+(end-start)/2;
            if(nums[middle] > target)
                end = middle-1;
            else if (nums[middle] < target)
                start = middle+1;
            else
                return middle;
        }
        return -1;
    }


//    //394. Decode String
//    public String decodeString(String s) {
//
//    }

    //75. Sort Colors
    public static void sortColors(int[] nums) {
        int n = nums.length;

        int upperBound = 0;
        int lowerBound = n-1;
        int i = 0;
        while(i <= lowerBound)
        {
            if(nums[i] < 1)
            {
                int temp = nums[upperBound];
                nums[upperBound] = nums[i];
                nums[i] = temp;
                upperBound++;
                i++;
            }
            else if(nums[i] > 1)
            {
                int temp = nums[lowerBound];
                nums[lowerBound] = nums[i];
                nums[i] = temp;
                lowerBound--;
            }
            else
            {
                i++;
            }
        }
    }




    public boolean isMonotonic(int[] nums) {
        int n = nums.length;

        if(n==0) return true;

        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for(int i = 1; i < n; i++)
        {
            if(!isIncreasing && !isDecreasing)
                return false;

            if(nums[i] > nums[i-1]) isIncreasing = false;

            if(nums[i] < nums[i-1]) isDecreasing = false;
        }
        return isIncreasing || isDecreasing;
    }


    public static String addStrings(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int result = 0;

        int i = num1Array.length-1;
        int j = num2Array.length - 1;

        while(i >= 0 && j >=0)
        {
            result*=10;
            result += (num1Array[i] - '0') + (num2Array[j] - '0');
            j--;
            i--;
        }

        while(i >= 0)
        {
            result*=10;
            result += (num1Array[i] - '0');
            i--;
        }

        while(j >=0)
        {
            result*=10;
            result += (num2Array[j] - '0');
            j--;
        }

        int finalResult = 0;
        while(result>0)
        {
            finalResult*=10;
            finalResult += result%10;
            result/=10;
        }


        return String.valueOf(finalResult);
    }


    //1299. Replace Elements with Greatest Element on Right Side
    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i = arr.length-1; i >= 0; i--)
        {
            if(arr[i]>max)
            {
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            }
            else
                arr[i] = max;
        }
        return arr;
    }

    //53. Maximum Subarray
    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int number:nums)
        {
            if(currentSum < 0)
                currentSum=0;

            currentSum+=number;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    //59. Spiral Matrix II
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = n-1;
        int currentNumber = 1;


        while(left<=right && top <= bottom)
        {
            for(int i = left; i <= right; i++)
                result[top][i] = currentNumber++;
            top++;

            for(int i = top; i <= bottom; i++)
                result[i][right] = currentNumber++;
            right--;

            for(int i = right; i >= left;i--)
                result[bottom][i] = currentNumber++;
            bottom--;

            for(int i = bottom; i >= top;i--)
                result[i][left] = currentNumber++;
            left++;
        }
        return result;
    }

    //54. Spiral Matrix
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;

        while(left <= right && top <= bottom)
        {
            for(int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;

            for(int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            if(bottom >= top)
            {
                for(int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            }

            if(right >= left)
            {
                for(int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }

    //151. Reverse Words in a String
    public static String reverseWords(String s) {
        List<String> words = new ArrayList<String>();

        for(int i = 0; i < s.length(); i++)
        {
            StringBuilder sb = new StringBuilder();
            while(i < s.length() &&
                    (Character.isAlphabetic(s.charAt(i))  ||  Character.isDigit(s.charAt(i))))
                sb.append(s.charAt(i++));

            if(!sb.isEmpty())
                words.add(sb.toString());
        }

        StringBuilder result = new StringBuilder();
        for(int i = words.size()-1; i >= 0; i--)
        {
            result.append(words.get(i));

            if(i!=0)
                result.append(" ");
        }

        return result.toString();
    }



    public static boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[i].length; j++)
            {
                if(matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }

    //75. Sort Colors


    //128. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int maxLength = 0;

        for (int num : nums) seen.add(num);

        for(int num:seen)
        {
            int length = 0;
            if(!seen.contains(num-1))
            {
                length++;
                while(seen.contains(num+length))
                    length++;

                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

//    169. Majority Element
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for(int i = 0; i <nums.length; i++)
        {
            if(count == 0)
                candidate = nums[i];

            if(candidate == nums[i])
                count++;
            else
                count--;
        }
        return candidate;
    }




    //2149. Rearrange Array Elements by Sign
    public static int[] rearrangeArray(int[] nums) {
        int p = 0;
        int n = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(i%2==0 && nums[i]>0)
            {
                p+=2;
                continue;
            }
            else if (i%2!=0 && nums[i]<0)
            {
                n+=2;
                continue;
            }

            if(n < nums.length && nums[i]>0)
            {
                int temp = nums[n];
                nums[n] = nums[i];
                nums[i] = temp;
                n+=2;
            }

            if(p < nums.length && nums[i]>0)
            {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p+=2;
            }
        }
        return nums;
    }


    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> seenStack = new ArrayDeque<>();

        for (int asteroid : asteroids) {

            if (asteroid > 0) {
                seenStack.push(asteroid);
            }
            else
            {
                while(!seenStack.isEmpty() && seenStack.peek() > 0 && seenStack.peek() < -asteroid)
                {
                    seenStack.pop();
                }

                if(seenStack.isEmpty() || seenStack.peek() < 0)
                    seenStack.push(asteroid);

                if(!seenStack.isEmpty() && seenStack.peek() == -asteroid)
                    seenStack.pop();
            }
        }


        int stackSize = seenStack.size();
        int[] result = new int[stackSize];
        while(!seenStack.isEmpty())
            result[--stackSize] = seenStack.pop();

        return result;
    }



    public static int[][] transpose(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int[][] result = new int[columnLength][rowLength];

        for(int i = 0; i < rowLength; i++)
        {
            for(int j = 0; j < columnLength; j++)
            {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

//    public static int deleteGreatestValue(int[][] grid) {
//        int rowLength = grid.length;
//        int columnLength = grid[0].length;
//
//        for(int i = 0; i < rowLength; i++)
//            Arrays.sort(grid[i]);
//
//        for(int i = 0; i < columnLength; i++)
//        {
//            for(int j = rowLength; j >=0 ; j--)
//            {
//                System.out.println(grid[j][i]);
//            }
//        }
//        return -1;
//    }


    //1247. Minimum Swaps to Make Strings Equal
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n != m) return -1;

        int xMiss = 0;
        int yMiss = 0;

        for(int i = 0; i < n; i++)
        {
            if(s1.charAt(i) == 'y' && s2.charAt(i)=='x')
                xMiss++;
            else if (s1.charAt(i)=='x' && s2.charAt(i) == 'y')
                yMiss++;
        }

        if(xMiss % 2 != yMiss % 2) return -1;

        int totalSwaps = xMiss/2 + yMiss/2;
        if (xMiss % 2 == 1) {
            totalSwaps += 2;
        }
        return totalSwaps;
    }


    //1790. Check if One String Swap Can Make Strings Equal
    public boolean areAlmostEqual(String s1, String s2) {

        if(s1.length() != s2.length())
            return false;

        if(s1.equals(s2))
            return true;

        char[] string1Characters = s1.toCharArray();
        char[] string2Characters = s2.toCharArray();


        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < string1Characters.length; i++)
        {
            if(string1Characters[i] != string2Characters[i])
                indices.add(i);
        }

        if(indices.size() != 2) return false;

        char temp = string1Characters[indices.get(0)];
        string1Characters[indices.get(0)]=string1Characters[indices.get(1)];
        string1Characters[indices.get(1)] = temp;

        return Arrays.equals(string1Characters,string2Characters);
    }



    //problems to repeat
    //1657. Determine if Two Strings Are Close
    //1347. Minimum Number of Steps to Make Two Strings Anagram
    //859. Buddy Strings


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
//    public static int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while(left<=right)
//        {
//            int middle = (right+left)/2;
//            if(nums[middle] == target)
//                return middle;
//            else if (nums[middle] > target)
//                right = middle - 1;
//            else
//                left = middle + 1;
//        }
//        return -1;
//    }





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