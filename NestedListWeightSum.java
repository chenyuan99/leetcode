// package VO;

import java.util.*;

public class NestedListWeightSum {
    
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger element : nestedList) {
            q.offer(element);
        }
        int depth = 0, sum = 0;
        // BFS遍历
        while(!q.isEmpty()) {
            depth++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                NestedInteger cur = q.poll();
                if(cur.isInteger()) {
                    sum += depth * cur.getInteger();
                }else {
                    List<NestedInteger> tmp = cur.getList();
                    for(NestedInteger element : tmp) {
                        q.offer(element);
                    }
                }
            }
        }
        return sum;
    }
    
    // 作者：LeetCode
    // 链接：https://leetcode-cn.com/problems/nested-list-weight-sum/solution/qian-tao-lie-biao-quan-zhong-he-by-leetcode-2/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
}
