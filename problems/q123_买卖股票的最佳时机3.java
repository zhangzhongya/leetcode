package problems;

import java.util.Arrays;

public class q123_买卖股票的最佳时机3 {
	//方法一：比较暴力的方法，leetcode运行约700ms
	public int maxProfit(int[] prices) {
		if(prices.length<2)
			return 0;
        int[] arr = new int[prices.length];
        int max = 0;
        for(int i=0;i<prices.length;i++) {
        	if(i+1<prices.length && prices[i+1]>prices[i])
        		continue;
        	max = Math.max(maxP(prices, 0, i)+maxP(prices, i+1, prices.length-1), max);
        }
        return max;
    }
	
	public int maxP(int[] prices, int low, int high) {
		if(low>=high)
			return 0;
		int min = prices[low];
		int max = 0;
		for(int i=low;i<=high;i++) {
			if(prices[i]<min)
				min = prices[i];
			else
				max = Math.max(max, prices[i]-min);
			
		}
		return max;
	}
	
	//方法二：动态规划的方法，leetcode运行约3ms
	/*
	 * 使用两个动态规划数组，类比登山问题；
	 * dp1表示的是从0到prices[i]中一次交易最大的收益
	 * dp2表示从prices[prices.length-1]到prices[i]之间（倒着计算）中一次交易最大的收益
	 * 两次交易的话，肯定是从某个位置i分开的，所以计算开头到prices[i]和prices[i]到结尾两个阶段中交易收益相加的最大值
	 * 则计算得到的最大值就是要求的两个交易的最大收益。
	 * 例如序列：[1,2,4,2,5,7,2,4,9,0]
	 * dp1 = [0, 1, 3, 3, 4, 6, 6, 6, 8, 8]
	 * dp2 = [8, 7, 7, 7, 7, 7, 7, 5, 0, 0]
	 * 所以从prices[5]分开，前后两个阶段的两次交易总收益是最大的为13。
	 * */
	public static int maxProfit_2(int[] prices) {
		if(prices.length<2)
			return 0;
		int[] dp1 = new int[prices.length];
		int[] dp2 = new int[prices.length];
		int min = prices[0];
		int max = 0;
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<min)
				min = prices[i];
			dp1[i] = Math.max(dp1[i-1], prices[i]-min);
		}
		
		min = prices[prices.length-1];
		max = 0;
		for(int i=prices.length-2;i>=0;i--) {
			if(prices[i]>min)
				min = prices[i];
			dp2[i] = Math.max(dp2[i+1], min-prices[i]);
		}
		max = 0;
		for(int i=0;i<prices.length;i++) {
			max = Math.max(max, dp1[i]+dp2[i]);
		}
		System.out.println(Arrays.toString(dp1));
		System.out.println(Arrays.toString(dp2));
		return max;
		
	}
	
	
	/*
	 * 方法三：从评论区看到的一个思路
	 * 对于任意一天考虑四个变量:
        fstBuy: 在该天第一次买入股票可获得的最大收益 
        fstSell: 在该天第一次卖出股票可获得的最大收益
        secBuy: 在该天第二次买入股票可获得的最大收益
        secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
	 * */
	public int maxProfit_3(int[] prices) {
		int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p); 
        }
        return secSell;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,4,2,5,7,2,4,9,0};
//		int[] nums = new int[] {2,1,2,0,1};
		int max = q123_买卖股票的最佳时机3.maxProfit_2(nums);
		System.out.println(max);
	}
	
}
