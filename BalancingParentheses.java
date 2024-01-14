public class BalancingParentheses {
    // https://leetcode.com/discuss/interview-question/124551/balance-parenthesis-in-an-alphanumeric-string
    public String balanceParens(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(n);
        boolean[] remove = new boolean[n];
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else if (str.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    remove[i] = true;
                }
            }
        }
    
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == ')') {
                close++;
            } else if (str.charAt(i) == '(') {
                if (close > 0) {
                    close--;
                } else {
                    remove[i] = true;
                }
            }
        }
    
        for (int i = 0; i < n; i++) {
            if (!remove[i]) sb.append(str.charAt(i));
        }
    
        return sb.toString();
    }
}
