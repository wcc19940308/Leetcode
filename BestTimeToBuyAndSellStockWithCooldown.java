package LeetCode100;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        s0[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = Math.max(s1[i - 1] + prices[i], s2[i - 1]);
        }
        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }
}
