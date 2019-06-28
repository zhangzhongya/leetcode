package sort;

import java.util.Arrays;
import java.util.Random;

//选择排序
public class selectionSort {
	//直接选择排序
	public static void simpleSelectionSort(int[] arr) {
		int len = arr.length;
		int temp=0,index=0;
		if(len<=1)
			return;
		for(int i=0;i<len-1;i++) {
			index = i;
			for(int j=i+1;j<len;j++) {
				if(arr[j]<arr[index])
					index = j;
			}
			if(index!=i) {
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
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
		simpleSelectionSort(arr);
		System.out.println("sort array:" + Arrays.toString(arr));
		
	}
	
}
