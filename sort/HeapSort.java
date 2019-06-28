package sort;

import java.util.Random;
import java.util.Arrays;
public class HeapSort {
	public static void heapSort(int[] arr) {
		for(int i=arr.length/2-1;i>=0;i--) {
			adjustHeap(arr, i, arr.length);
		}
		for(int i=arr.length-1; i>0; i--) {
			swap(arr, 0, i);
			adjustHeap(arr, 0, i);
		}
	}
	
	public static void adjustHeap(int[] arr, int i, int length) {
		int k = i*2+1;
		while(k<length) {
			if(k+1<length && arr[k+1]>arr[k])
				k++;
			if(arr[k]>arr[i])
				swap(arr, k, i);
			else
				break;
			
			i = k;
			k = i*2+1;
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[20];
//		int[] arr = new int[] {66, 66, 77, 12, 48, 41, 17, 62, 61, 16};
		Random rand = new Random();
		for(int i=0;i<arr.length;i++)
			arr[i] = rand.nextInt(100);
		System.out.println(Arrays.toString(arr));
		
		
		HeapSort.heapSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
