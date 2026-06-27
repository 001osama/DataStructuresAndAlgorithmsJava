package String;

import java.util.*;

public class FrequencyProblems {

    //242. Valid Anagram
    public static boolean isAnagram(String s, String t) {
        int[] seen = new int[26];
        for(char character:s.toCharArray())
            seen[character-'a']++;

        for(char character:t.toCharArray())
            seen[character-'a']--;

        for(int num:seen)
            if(num!=0)
                return false;

        return true;
    }


    //387. First Unique Character in a String
    public static int firstUniqChar(String s) {
        char[] characterArray = s.toCharArray();
        int[] repo = new int[26];

        for(int i = 0; i < characterArray.length;i++)
            repo[characterArray[i]-'a']++;

        for(int i = 0; i < characterArray.length;i++)
            if(repo[characterArray[i]-'a'] == 1)
                return i;

        return -1;
    }

    //1832. Check if the Sentence Is Pangram
    public boolean checkIfPangram(String sentence) {
        int[] repo = new int[26];

        for(char character:sentence.toCharArray())
            repo[character-'a']++;

        for(int number:repo)
            if(number==0)
                return false;

        return true;
    }


    //217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> repo = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(repo.contains(nums[i]))
                return true;
            repo.add(nums[i]);
        }
        return false;
    }


    //383. Ransom Note
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        int[] frequency = new int[26];
        var characterArray = magazine.toCharArray();
        for(char character:characterArray)
            frequency[character-'a']++;

        characterArray = ransomNote.toCharArray();
        for(char character:characterArray)
        {
            if(frequency[character-'a'] == 0) return false;
            frequency[character-'a']--;
        }
        return true;
    }


    //1512. Number of Good Pairs
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> seen = new HashMap<Integer, Integer>();
        int result = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(seen.containsKey(nums[i]))
            {
                int exists = seen.get(nums[i]);
                result+=exists;
                seen.put(nums[i], exists+1);
            }

            else seen.put(nums[i],1);

        }
        return result;
    }


    //1657. Determine if Two Strings Are Close
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        for(char alphabet:word1.toCharArray())
            frequency1[alphabet-'a']++;

        for(char alphabet:word2.toCharArray())
            frequency2[alphabet-'a']++;

        for(int i = 0; i<frequency1.length; i++)
        {
            if(!(frequency1[i] == 0 && frequency2[i] == 0) &&
                    !(frequency1[i] != 0 && frequency2[i] != 0))
                return false;
        }

        Arrays.sort(frequency1);
        Arrays.sort(frequency2);

        return Arrays.compare(frequency1,frequency2)==0;
    }

    //1347. Minimum Number of Steps to Make Two Strings Anagram
    public static int minSteps(String s, String t) {
        if(s.length() != t.length())
            return 0;

        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];


        for(int i = 0; i < s.length(); i++)
        {
            frequency1[s.charAt(i) - 'a']++;
            frequency2[t.charAt(i) - 'a']++;
        }

        int totalDifference = 0;
        for(int i = 0 ; i < frequency1.length; i++)
        {
            if(frequency1[i] != frequency2[i])
                totalDifference+= Math.abs(frequency2[i] - frequency1[i]);
        }

        return totalDifference == 0 ? totalDifference : (totalDifference + 2 - 1)/2;
    }

    //859. Buddy Strings
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;

        char[] characters1 = s.toCharArray();
        char[] characters2 = goal.toCharArray();

        if(s.equals(goal))
        {
            int[] frequency1 = new int[26];

            for(int i = 0; i<characters1.length; i++)
            {
                frequency1[characters1[i] - 'a']++;

                if(frequency1[characters1[i] - 'a'] > 1)
                    return true;
            }
            return false;
        }


        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(characters1[i] != characters2[i])
                indices.add(i);
        }

        if(indices.size() != 2) return false;

        char temp = characters1[indices.get(0)];
        characters1[indices.get(0)] = characters1[indices.get(1)];
        characters1[indices.get(1)] = temp;

        return Arrays.equals(characters1, characters2);
    }
}
