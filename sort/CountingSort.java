package sort;
import java.util.Arrays;
import java.util.Random;
//¼ÆÊýÅÅÐò
public class CountingSort {
	
	public static void countingSort(int[] nums) {
		if(nums.length==0)
			return;
		int maxVal=nums[0], minVal=nums[0];
		for(int val:nums) {
			if(val>maxVal) {
				maxVal = val;
			}else if(val<minVal) {
				minVal =val;
			}
		}
		
		int[] arrs = new int[maxVal-minVal+1];
		for(int val:nums) {
			arrs[val-minVal] += 1;
		}
		
		int j=0;
		for(int i=0;i<arrs.length;i++) {
			while(arrs[i]>0) {
				nums[j++] = i+minVal;
				arrs[i] -= 1;
			}
		}
		return ;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[20];
		Random rand = new Random();
		for(int i=0;i<20;i++) {
			nums[i] = rand.nextInt(10);
		}
		
		System.out.println(Arrays.toString(nums));
		countingSort(nums);
		System.out.println(Arrays.toString(nums));
		
		
	}
}
