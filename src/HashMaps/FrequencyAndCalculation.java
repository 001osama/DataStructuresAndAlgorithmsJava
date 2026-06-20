package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAndCalculation {

    //1679. Max Number of K-Sum Pairs
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int numberOfOperations = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int remainingValue = k-nums[i];
            if(seen.containsKey(remainingValue))
            {
                int frequency = seen.get(remainingValue);
                numberOfOperations++;
                if(frequency > 1)
                    seen.put(remainingValue, seen.get(remainingValue)-1);
                else
                    seen.remove(remainingValue);
            }
            else
                seen.put(nums[i],seen.getOrDefault(nums[i],0)+1);
        }
        return numberOfOperations;
    }
}
