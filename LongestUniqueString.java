// package VO;

import java.util.*;

public class LongestUniqueString{

    public static String longestUniqueString(String[] s){
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> pq = new PriorityQueue<>((x, y) -> x.length()-y.length());
        int[] dp = new int[s.length+1];
        dp[0] = 0;
        List<String> visited = new ArrayList<>();
        for(int i =0;i<s.length;i++){
            String tempString = s[i];
            if(map.get(tempString)==null){
                map.put(tempString,1);
                pq.add(tempString);
            }else{
                int freq = map.get(tempString);
                map.put(tempString,freq+1);
                if(freq==1) pq.remove(tempString);
            }
        }

        // Queue<String> pq = new PriorityQueue<>();
        return pq.peek();
        // for(Map.EntrySet<String, Integer> set : Map)
    }

    public static void main(String[] args){
        String[] testString = {"a","aaa","aaa","aa"};
        System.out.println(longestUniqueString(testString));
    }

}