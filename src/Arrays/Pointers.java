package Arrays;

import java.util.HashMap;

public class Pointers {

    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> repo = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            int remain = target - nums[i];
            if(repo.containsKey(remain))
                return new int[]{nums[i], repo.get(remain)};
            repo.put(nums[i],i);
        }
        return new int[2];
    }
}
