package problems;

public class q137 {
	/*
    �����е�˼·���൱�����һ��״̬ת���������һ��������3�����Զ�����Ϊ0�����ʣ�µľ���ֻ����һ�ε�����
    Ҫ��¼���Σ�����Ҫ����������λ������Ҫ�������¼������
    00 (+) 1 = 01

    01 (+) 1 = 10

    10 (+) 1 = 00 ( mod 3)
    ��a��ʾ��λ��b��ʾ��λ����ab����ab��ʾĳһλ�����˶��ٴ�1��
    �������λ��һ������1����a = 0, b = 1;
        �����λ�ڶ�������1����a = 1��b = 0;
        �����λ����������1����a = 0, b = 0��
    */
	public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num: nums){
            b = (b^num) & ~a;
            a = (a^num) & ~b;
        }
        return b;
    }
	
	//�����һ�������У�һ����ֻ����һ�Σ������Ķ�������k�Σ����ҳ��������һ�ε�������ô����
	/*������һ��32λ�����飬�������ÿ��Ԫ��������ǰ����Ӧ��λ��1���ֵĴ�����
	������ִ�����k������������˵������һ�ε��Ǹ����ڸ�λ��0���������1��
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
