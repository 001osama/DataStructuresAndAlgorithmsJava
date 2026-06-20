// PasswordDecryptionSolution.java
package HackerRankCodeRunner.Problems.PasswordDecryption;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class PasswordDecryptionSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        String s = in.nextLine().trim();

        out.println(decryptPassword(s));
    }

    private String decryptPassword(String s) {
        List<Character> result = new ArrayList<>();
        char[] charactersArray = s.toCharArray();

        int upperBound = -1;
        for(int i = charactersArray.length - 1; i >= 0 && upperBound<i; i-- )
        {
            if(charactersArray[i] == '0')
            {
                result.add(charactersArray[++upperBound]);
            }
            else if(charactersArray[i] == '*')
            {
                result.add(charactersArray[i-2]);
                result.add(charactersArray[i-1]);
                i-=2;
            }
            else
                result.add(charactersArray[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : result.reversed()) {
            sb.append(c);
        }

        return sb.toString();
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/PasswordDecryption/TestCases";
    }

}