package problems;

/*题目描述：
 *两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
*计算一个数组中，任意两个数之间汉明距离的总和。
 */
//解体思路：
//这道题是之前两个数的Hamming Distance的拓展
//根据之前那道题的经验，我们知道需要用异或来求每个位上的情况
//我们根据例子来看一下规律：4，14，2，1：

//4:     0 1 0 0
//14:    1 1 1 0
//2:     0 0 1 0
//1:     0 0 0 1
//我们先看最后一列，有三个0和一个1，那么它们之间相互的汉明距离就是3，即1和其他三个0分别的距离累加
//然后在看第三列，累加汉明距离为4，因为每个1都会跟两个0产生两个汉明距离
//同理第二列也是4，第一列是3
//所以某一位的累计汉明距离个数，其实就是所有数在该位0的个数乘以1的个数
//根据这个规律，只要统计出每一位的1的个数即可，题目就解决了，参见代码如下：
public class q477_汉明距离总和 {
	public int totalHammingDistance(int[] nums) {
        int res = 0;
        int sum = 0;
        int mask = 1;
        for(int i=0;i<32;i++){
            mask = 1<<i;
            sum = 0;
            for(int j=0;j<nums.length;j++){
                if((mask&nums[j])!=0)
                    sum++;
            }
            res += sum*(nums.length-sum);
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
