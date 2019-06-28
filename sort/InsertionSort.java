package sort;

import java.util.Arrays;
import java.util.Random;

//插入排序
public class InsertionSort {
	//直接插入排序
	public static void straightInsertSort(int[] arr) {
		for(int i=1;i<arr.length;i++)
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else{
					break;
				}
			}
	}
	
	//直接插入排序
	public static void straightInsertSortV2(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int j=i;
			while(j>0 && arr[j]<arr[j-1]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}
	}
	
	public static void binaryInsertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int low=0, high=i;
			int num = arr[i];
			while(low<=high) {
				int m = (low+high)/2;
				if(arr[m]<arr[i])
					low=m+1;
				else
					high=m-1;
			}
			for(int j=i-1;j>high;j--)
				arr[j+1] = arr[j];
			arr[high+1] = num;	
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			int value = rand.nextInt(100);
			arr[i] = value;
		}
		System.out.println("src array: " + Arrays.toString(arr));
//		straightInsertSort(arr);
//		System.out.println("sort array:" + Arrays.toString(arr));
//		straightInsertSortV2(arr);
//		System.out.println("sort array:" + Arrays.toString(arr));
		binaryInsertionSort(arr);
		System.out.println("sort array:" + Arrays.toString(arr));
		
	}
}
