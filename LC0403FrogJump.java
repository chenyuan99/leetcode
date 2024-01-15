import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0403FrogJump {
     public boolean canCross(int[] stones) {
        int n = stones.length;

        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);

         for (int stone : stones) {
             for (int k : dp.get(stone)) {
                 for (int step = k - 1; step <= k + 1; step++) {
                     if (step != 0 && dp.containsKey(stone + step)) {
                         dp.get(stone + step).add(step);
                     }
                 }
             }
         }

        return !dp.get(stones[n - 1]).isEmpty();
    }
}

// https://leetcode.com/problems/frog-jump/description/