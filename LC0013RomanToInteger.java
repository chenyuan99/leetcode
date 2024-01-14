import java.util.HashMap;

public class LC0013RomanToInteger {

    class Solution {
        public int romanToInt(String s) {
            HashMap<String, Integer> dict = new HashMap<String, Integer>();
            dict.put("I", 1);
            dict.put("V", 5);
            dict.put("X", 10);
            dict.put("L", 50);
            dict.put("C", 100);
            dict.put("D", 500);
            dict.put("M", 1000);
            dict.put("IV", 4);
            dict.put("IX", 9);
            dict.put("XL", 40);
            dict.put("XC", 90);
            dict.put("CD", 400);
            dict.put("CM", 900);
            if (s.length() == 1) {
                return dict.get(s);
            }
            int temp = 0;
            int i = 0;
            while (i < s.length()) {
                if (i < s.length() - 1 && dict.get(s.substring(i, i + 2)) != null) {
                    temp = temp + dict.get(s.substring(i, i + 2));
                    i = i + 2;
                } else {
                    temp = temp + dict.get(s.substring(i, i + 1));
                    i = i + 1;
                }
            }

            return temp;
        }

    }
}
