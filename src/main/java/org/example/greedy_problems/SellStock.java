package org.example.greedy_problems;

public class SellStock {

    /**
     * task: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a><br>
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(1)}<br>
     * difficulty: {@code easy}
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /**
     * task: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II</a><br>
     * time complexity: {@code O(N)}
     * space complexity: {@code O(1)}
     * difficulty: {@code medium}
     */
    public int maxProfit2(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                totalProfit += prices[i + 1] - prices[i];
            }
        }
        return totalProfit;
    }

    /**
     * task: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">Best Time to Buy and Sell Stock with Transaction Fee</a><br>
     * time complexity: {@code O(N)}
     * space complexity: {@code O(1)}
     * difficulty: {@code medium}
     */
    public int maxProfit3(int[] prices, int fee) {
        int minPrice = prices[0];
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > fee) {
                totalProfit += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;
            }
        }
        return totalProfit;
    }


}
