import java.util.HashMap;
import java.util.HashSet;

public class LC1817FindingtheUsersActiveMinutes {
     public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result=new int[k];
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        
        for(int[] log:logs){
            int id=log[0];
            int t=log[1];
            if(!map.containsKey(id)) map.put(id,new HashSet<>());
            map.get(id).add(t);
        }
        
        for(int id:map.keySet()){
             int UAM=map.get(id).size();
             result[UAM-1]++;  
        }
        return result;
    }
}

// https://leetcode.com/problems/finding-the-users-active-minutes/