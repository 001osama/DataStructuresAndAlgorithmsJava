// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.StringAnagram;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class StringAnagramSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n               = readInt(in);
        String[] dictionary = readStringArray(in, n);

        int q               = readInt(in);
        String[] query      = readStringArray(in, q);

        int[] result = stringAnagram(dictionary, query);
        printArray(out, result);
    }

    private int[] stringAnagram(String[] dictionary, String[] query) {
        Map<String, Integer> map = new HashMap<>();
        int[] result = new int[query.length];

        for(String word:dictionary)
        {
            int[] histogram = new int[26];
            for(char character:word.toCharArray())
                histogram[character-'a']++;

            String stringHistogram = Arrays.toString(histogram);
            map.put(stringHistogram,map.getOrDefault(stringHistogram, 0)+1) ;
        }


        for(int i = 0; i < query.length; i++)
        {
            String word = query[i];
            int[] histogram = new int[26];
            for(char character:word.toCharArray())
                histogram[character-'a']++;

            String stringHistogram = Arrays.toString(histogram);
            if(map.containsKey(stringHistogram))
                result[i] = map.get(stringHistogram);
        }

        return result;
    }





    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/StringAnagram/TestCases";
    }

}