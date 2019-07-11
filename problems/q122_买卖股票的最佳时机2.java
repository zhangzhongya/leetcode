package problems;

public class q122_买卖股票的最佳时机2 {
	public int maxProfit(int[] prices) {
        if(prices.length<2)
        	return 0;
        int minPri = prices[0];
        int sum = 0;
        for(int i=0;i<prices.length;i++) {
        	if(prices[i]>minPri)
        		sum += prices[i] - minPri;
        	minPri = prices[i];
        }
        return sum;
    }
}
