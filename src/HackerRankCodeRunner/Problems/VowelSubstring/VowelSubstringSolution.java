package HackerRankCodeRunner.Problems.VowelSubstring;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class VowelSubstringSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        String s = in.nextLine().trim();
        int k    = readInt(in);

        out.println(findSubstring(s, k));
    }

    private String findSubstring(String s, int k) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int maxVowelsCount = 0;
        int currentVowelsCount = 0;
        String maxVowelString = "";

        char[] characters = s.toCharArray();

        int left = 0;
        int right = 0;
        while(left <= right && right < characters.length)
        {
            if(vowels.contains(characters[right]))
                currentVowelsCount++;


            if (right-left+1 < k)
            {
                right++;
                continue;
            }

            while(right-left+1 > k)
            {
                if(vowels.contains(characters[left]))
                    currentVowelsCount--;
                left++;
            }

            if(right-left+1 == k)
            {
                if(currentVowelsCount > maxVowelsCount)
                {
                    maxVowelString = String.valueOf(characters,left,right-left+1);
                    maxVowelsCount = currentVowelsCount;
                }
            }
            right++;
        }

        return maxVowelString.length() > 0 ? maxVowelString : "Not found!";
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/VowelSubstring/TestCases";
    }

}