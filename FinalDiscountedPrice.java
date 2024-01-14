import java.util.*;

class Solution {
    public class FinalDiscountedPrice {

        public long finalPrice(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int[] temp = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                temp[i] = prices[i];
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < prices.length; i++) {
                while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                    int cur = stack.pop();
                    temp[cur] = prices[cur] - prices[i];
                }
                stack.push(i);
            }

            long sum = 0;
            for (int tempPrice : temp) {
                sum += tempPrice;
            }

            return sum;
        }


    }

    public void main(String[] args) {
        int[] prices = new int[]{2, 3, 1, 2, 4, 2};
        FinalDiscountedPrice test = new FinalDiscountedPrice();
        System.out.println(test.finalPrice(prices));
    }
}


//        https://leetcode.com/discuss/interview-question/378221/Twitter-or-OA-2019-or-Final-Discounted-Price
//  monotonically non-decreasing stack.