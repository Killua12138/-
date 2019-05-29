package leetcode;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = prices[0],max = 0,res = 0;
        for (int i = 0; i < prices.length; i++){
            if (res < max - min)
                res = max - min;
            if (prices[i] < min)
                min = prices[i];
        }
        return res;
    }
}
