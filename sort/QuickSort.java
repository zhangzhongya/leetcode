package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
/*
 * 快速排序
 * 最大时间复杂度为O(n^2)
 * 平均时间复杂度为O(n*logn)
 * */
public class QuickSort {
	private static int count = 0;
	public static void quickSort(int[] arr) {
		quickSortFunc(arr, 0, arr.length-1);
	}
	
	public static void quickSortFunc(int[] arr, int left, int right) {
		if(left>=right)
			return;
		int r = right, l = left, temp = arr[left];
		while(left<right) {
			while(left<right && arr[right]>=temp)
				right--;
			if(left<right)
				arr[left] = arr[right];
			while(left<right && arr[left]<temp)
				left++;
			if(left<right)
				arr[right] = arr[left];
		}
		arr[left] = temp;
		System.out.println((count++)+":"+Arrays.toString(arr));
		quickSortFunc(arr, l, left-1);
		quickSortFunc(arr, left+1, r);
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[19];
//		int[] arr = new int[] {66, 66, 77, 12, 48, 41, 17, 62, 61, 16};
//		int[] arr = new int[] {9, 7, 2, 3, 8, 9, 1, 3, 0, 2, 4, 1, 1, 9, 3, 1, 1, 6, 6};
		int[] arr = new int[] {1,1,2,1};
		//		Random rand = new Random();
//		for(int i=0;i<arr.length;i++)
//			arr[i] = rand.nextInt(10);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		
		QuickSort.quickSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
}
