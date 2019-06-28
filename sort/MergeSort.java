package sort;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
	
	public static void mSort(int[] arr, int left, int right, int[] temp) {
		if(left<right) {
			int m = (left+right)/2;
			mSort(arr, left, m, temp);
			mSort(arr, m+1, right, temp);
			merge(arr, left, m, right, temp);
		}
	}
	
	public static void merge(int[] arr, int left, int m, int right, int[] temp) {
		int i=left, j=m+1;
		int index = 0;
		while(i<=m && j<=right) {
			if(arr[i]<=arr[j]) {
				temp[index++] = arr[i++];
			}else {
				temp[index++] = arr[j++];
			}
		}
		while(i<=m)
			temp[index++] = arr[i++];
		while(j<=right)
			temp[index++] = arr[j++];
		for(i=left, index=0;i<=right;) {
			arr[i++] = temp[index++];
		}
	}
	
	public static boolean mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		if(temp==null)
			return false;
		mSort(arr, 0, arr.length-1, temp);
		return true;
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[19];
		int[] arr = new int[] {66, 66, 77, 12, 48, 41, 17, 62, 61, 16, 99};
//		int[] arr = new int[] {9, 7, 2, 3, 8, 9, 1, 3, 0, 2, 4, 1, 1, 9, 3, 1, 1, 6, 6};
//		int[] arr = new int[] {1,1,2,1};
		//		Random rand = new Random();
//		for(int i=0;i<arr.length;i++)
//			arr[i] = rand.nextInt(10);
		System.out.println(Arrays.toString(arr));
		
		int[] temp = new int[arr.length];
		MergeSort.mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
		Comparator com;
		
	}
}
