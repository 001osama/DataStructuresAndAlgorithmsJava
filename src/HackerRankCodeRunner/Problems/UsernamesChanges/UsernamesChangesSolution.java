// UsernamesChangesSolution.java
package HackerRankCodeRunner.Problems.UsernamesChanges;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class UsernamesChangesSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n               = readInt(in);
        String[] usernames  = readStringArray(in, n);

        printArray(out, possibleChanges(usernames));
    }

    private String[] possibleChanges(String[] usernames) {
        for(int i = 0; i < usernames.length; i++)
        {
            char[] characterArray = usernames[i].toCharArray();
            usernames[i]="NO";
            for(int j = 1; j < characterArray.length; j++)
            {
                if(characterArray[0] > characterArray[j])
                {
                    usernames[i] = "YES";
                    break;
                }
            }
        }
        return usernames;
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/UsernamesChanges/TestCases";
    }

}