package problems;

import java.util.Arrays;

public class q123_������Ʊ�����ʱ��3 {
	//����һ���Ƚϱ����ķ�����leetcode����Լ700ms
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
	
	//����������̬�滮�ķ�����leetcode����Լ3ms
	/*
	 * ʹ��������̬�滮���飬��ȵ�ɽ���⣻
	 * dp1��ʾ���Ǵ�0��prices[i]��һ�ν�����������
	 * dp2��ʾ��prices[prices.length-1]��prices[i]֮�䣨���ż��㣩��һ�ν�����������
	 * ���ν��׵Ļ����϶��Ǵ�ĳ��λ��i�ֿ��ģ����Լ��㿪ͷ��prices[i]��prices[i]����β�����׶��н���������ӵ����ֵ
	 * �����õ������ֵ����Ҫ����������׵�������档
	 * �������У�[1,2,4,2,5,7,2,4,9,0]
	 * dp1 = [0, 1, 3, 3, 4, 6, 6, 6, 8, 8]
	 * dp2 = [8, 7, 7, 7, 7, 7, 7, 5, 0, 0]
	 * ���Դ�prices[5]�ֿ���ǰ�������׶ε����ν���������������Ϊ13��
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
	 * ����������������������һ��˼·
	 * ��������һ�쿼���ĸ�����:
        fstBuy: �ڸ����һ�������Ʊ�ɻ�õ�������� 
        fstSell: �ڸ����һ��������Ʊ�ɻ�õ��������
        secBuy: �ڸ���ڶ��������Ʊ�ɻ�õ��������
        secSell: �ڸ���ڶ���������Ʊ�ɻ�õ��������
         �ֱ���ĸ�����������Ӧ�ĸ���, ���secSell�������
         ����ֵ(secSell >= fstSell)
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
		int max = q123_������Ʊ�����ʱ��3.maxProfit_2(nums);
		System.out.println(max);
	}
	
}
