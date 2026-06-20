package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    //1456. Maximum Number of Vowels in a Substring of Given Length
    public static int maxVowels(String s, int k) {
        int maxNumberOfVowel = 0;
        int currentNumberOfVowel = 0;
        char[] characters = s.toCharArray();

        int left = 0;
        int right = 0;
        Set<Character> vowels = new HashSet<>(Set.of('a','e','i','o','u'));
        while(right<characters.length)
        {
            if(vowels.contains(characters[right]))
                currentNumberOfVowel++;

            while(right-left+1 > k)
            {
                if(vowels.contains(characters[left]))
                    currentNumberOfVowel--;
                left++;
            }

            if(right-left+1 == k)
                maxNumberOfVowel = Math.max(currentNumberOfVowel, maxNumberOfVowel);

            right++;
        }
        return maxNumberOfVowel;
    }
}
