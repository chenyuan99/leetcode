import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC0380InsertDeleteGetRandom {
    class RandomizedSet {
        static int[] nums = new int[200010];
        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        int idx = -1;

        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            nums[++idx] = val;
            map.put(val, idx);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            int loc = map.remove(val);
            if (loc != idx)
                map.put(nums[idx], loc);
            nums[loc] = nums[idx--];
            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(idx + 1)];
        }
    }

    // 作者：AC_OIer
    // 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/solution/by-ac_oier-tpex/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
