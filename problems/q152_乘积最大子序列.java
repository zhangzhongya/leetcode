package problems;

/*题目描述：
 *  给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
//解题思路：
//动态规划
//遍历数组时计算当前最大值，不断更新
//令max为当前最大值，则当前最大值为 max = max(max * nums[i], nums[i])
//由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值min，min = min(min * nums[i], nums[i])
//当负数出现时则imax与imin进行交换再进行下一步计算
//时间复杂度：O(n)

public class q152_乘积最大子序列 {
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
