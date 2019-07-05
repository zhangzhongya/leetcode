package problems;

/*��Ŀ������
 *  ����һ���������� nums ���ҳ�һ�������г˻��������������У����������ٰ���һ��������
 */
//����˼·��
//��̬�滮
//��������ʱ���㵱ǰ���ֵ�����ϸ���
//��maxΪ��ǰ���ֵ����ǰ���ֵΪ max = max(max * nums[i], nums[i])
//���ڴ��ڸ�������ô�ᵼ�����ı���С�ģ���С�ı����ġ���˻���Ҫά����ǰ��Сֵmin��min = min(min * nums[i], nums[i])
//����������ʱ��imax��imin���н����ٽ�����һ������
//ʱ�临�Ӷȣ�O(n)

public class q152_�˻���������� {
	public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
