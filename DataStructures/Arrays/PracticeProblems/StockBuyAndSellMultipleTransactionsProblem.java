package DataStructures.Arrays.PracticeProblems;

public class StockBuyAndSellMultipleTransactionsProblem {

    /// In this problem, we have given an array with stock prices for some days, we have to find the maximum profit
    /// we can make by buying and selling the stock multiple times.

    /**
     * Naive Method (Recursive Method)
     * Time Complexity: O(2 ^ n)
     * */
    private static int maxProfitByNaiveMethod(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int profit = 0;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (prices[j] > prices[i]) {
                    int currentProfit = prices[j] - prices[i]
                            + maxProfitByNaiveMethod(prices, start, i - 1)
                            + maxProfitByNaiveMethod(prices, j + 1, end);

                    profit = Math.max(profit, currentProfit);
                }
            }
        }

        return profit;
    }

    /**
     * Efficient Method
     * Time Complexity: O(n)
     * */
    private static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 3, 8, 12};
//        int[] prices = {10, 20, 30};

        System.out.println("Max profit: " + maxProfitByNaiveMethod(prices, 0, prices.length - 1));
        System.out.println("Max profit: " + maxProfit(prices));
    }

}
