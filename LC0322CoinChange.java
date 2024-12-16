// package VO;

import java.util.Arrays;

public class LC0322CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] minCoins = new int[amount + 1];
        for (int k = 1; k <= amount; k++) {
            minCoins[k] = amount + 1;
            for (int i = 0; i < coins.length && coins[i] <= k; i++) {
                minCoins[k] = Math.min(minCoins[k], minCoins[k - coins[i]] + 1);
            }
        }
        return minCoins[amount] == amount + 1 ? -1 : minCoins[amount];
    }
}

//https://leetcode.com/problems/coin-change/description/