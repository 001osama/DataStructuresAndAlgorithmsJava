package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class TypicalProblems {

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
}
