package String;

import java.util.HashMap;
import java.util.HashSet;

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
}
