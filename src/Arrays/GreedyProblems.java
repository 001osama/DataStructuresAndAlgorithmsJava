package Arrays;

import java.util.Arrays;

public class GreedyProblems {

    //455. Assign Cookies
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while(gIndex < g.length && sIndex < s.length)
        {
            if(g[gIndex] <= s[sIndex])
                gIndex++;
            sIndex++;
        }
        return gIndex;
    }


    //2410. Maximum Matching of Players With Trainers
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int playersIndex = 0;
        int trainersIndex = 0;
        while(playersIndex < players.length && trainersIndex < trainers.length)
        {
            if(players[playersIndex] <= trainers[trainersIndex])
                playersIndex++;
            trainersIndex++;
        }
        return playersIndex;
    }


}
