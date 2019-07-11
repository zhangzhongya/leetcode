package problems;
/*
 * ���ͣ�̰��
 * �Ѷȣ���
 * */
public class q121_������Ʊ�����ʱ�� {
	public int maxProfit(int[] prices) {
		if(prices.length<2)
			return 0;
        int minNum = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++) {
        	if(prices[i]<minNum)
        		minNum = prices[i];
        	else {
        		max = Math.max(max, prices[i]-minNum);
        	}
        }
        return max;
    }
}
