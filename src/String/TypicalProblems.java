package String;

public class TypicalProblems {

    //151. Reverse Words in a String
    static String reverseWords(String s) {
        String[] wordList = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = wordList.length-1; i >= 0; i--)
        {
            sb.append(wordList[i]);
            if(i!=0)  sb.append(" ");
        }

        return sb.toString();
    }
}
