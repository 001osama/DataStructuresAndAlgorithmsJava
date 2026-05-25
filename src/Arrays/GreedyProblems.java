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

    //860. Lemonade Change
    public static boolean lemonadeChange(int[] bills) {
        int billOfFive = 0;
        int billOfTen = 0;
        for(int bill:bills) {

            if (bill == 5){
                billOfFive++;
            }
            else if(bill == 10)
            {
                if(billOfFive<=0) return false;
                billOfFive--;
                billOfTen++;
            }
            else
            {
                if( billOfTen>0 && billOfFive>0)
                {
                    billOfFive--;
                    billOfTen--;
                }
                else if(billOfFive>2)
                {
                    billOfFive-=3;
                }
                else return false;
            }

        }
        return true;
    }


}
