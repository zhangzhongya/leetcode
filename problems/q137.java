package problems;

public class q137 {
	/*
    看大佬的思路，相当于设计一个状态转换器，如果一个数出现3次能自动抵消为0，最后剩下的就是只出现一次的数。
    要记录三次，则需要两个二进制位，并且要满足以下计算规则：
    00 (+) 1 = 01

    01 (+) 1 = 10

    10 (+) 1 = 00 ( mod 3)
    用a表示高位，b表示低位，即ab，用ab表示某一位遇到了多少次1；
    则：如果该位第一次遇到1，则a = 0, b = 1;
        如果该位第二次遇到1，则a = 1，b = 0;
        如果该位第三次遇到1，则a = 0, b = 0；
    */
	public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num: nums){
            b = (b^num) & ~a;
            a = (a^num) & ~b;
        }
        return b;
    }
	
	//如果是一个数组中，一个数只出现一次，其他的都出现了k次，请找出这个出现一次的数，怎么做？
	/*可以用一个32位的数组，这个数组每个元素描述当前所对应的位中1出现的次数，
	如果出现次数是k的整数倍，则说明出现一次的那个数在该位是0，否则就是1。
	*/
	public static int singleNumberK(int[] nums, int k) {
		int[] mask = new int[32];
		int n = 1;
		for(int num : nums) {
			n = 1;
			for(int i=31;i>=0;i--) {
				mask[i] += (n&num)!=0?1:0;
				n = n<<1;
			}
		}
		int res = 0;
		n = 1;
		for(int i=31;i>=0;i--) {
			if(mask[i]%k != 0) {
				res |= n;
			}
			n = n<<1;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,3,5,5,5,3,3};
		int num = q137.singleNumberK(nums, 3);
		System.out.println(num);
	}

}
