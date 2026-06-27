import HackerRankCodeRunner.Problems.ActiveTraders.ActiveTradersSolution;
import HackerRankCodeRunner.Problems.LongestSubarray.LongestSubarraySolution;
import HackerRankCodeRunner.Problems.MaximumCostOfLaptopCount.MaximumCostOfLaptopCount;
import HackerRankCodeRunner.Problems.NearlySimilarRectangles.NearlySimilarRectanglesSolution;
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

//        var result2 = majorityElement(new int[]{3,2,3}); //3
//        var result = majorityElement(new int[]{2,2,1,1,1,2,2}); //3


        try
        {
            new TestCaseRunner(new SubarraySums()).runAll();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.print("Program ended with result: " + result );
//        System.out.print("Program ended with result: " + result2 );
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


    //394. Decode String
    public static String decodeString(String s) {
        int i = -1;
        Deque<String> repoStack = new ArrayDeque<>();
        Deque<Integer> numberStack = new ArrayDeque<>();
        while(++i < s.length())
        {
            if(s.charAt(i) >= '0' &&  s.charAt(i) <= '9')
            {
                int tempMultiplier = 0;
                while(s.charAt(i) >= '0' &&  s.charAt(i) <= '9'){
                    tempMultiplier *= 10;
                    tempMultiplier += s.charAt(i) - '0';
                    i++;
                }
                numberStack.push(tempMultiplier);
                i--;
                continue;
            }

            if(s.charAt(i) == ']')
            {
                StringBuilder sb = new StringBuilder();
                while(!repoStack.isEmpty() && !Objects.equals(repoStack.peek(), "["))
                    sb.insert(0,repoStack.pop());

                if(!repoStack.isEmpty() && Objects.equals(repoStack.peek(), "["))
                    repoStack.pop();

                int multiplier = numberStack.pop();

                String currentString = sb.toString();
                while(multiplier-- > 1)
                    sb.insert(0,currentString);

                repoStack.push(sb.toString());
            }
            else
                repoStack.push(String.valueOf(s.charAt(i)));
        }
        StringBuilder result = new StringBuilder();

        while(!repoStack.isEmpty())
            result.insert(0,repoStack.pop());


        return result.toString();
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