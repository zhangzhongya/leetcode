package sort;

import java.util.Random;
import java.util.Arrays;
//ц╟ещеепР
public class bubbleSort {
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		int temp=0;
		if(len<=1)
			return;
		for(int i=0;i<len-1;i++)
			for(int j=len-1;j>i;j--)
				if(arr[j-1]>arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
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
		bubbleSort(arr);
		System.out.println("sort array:" + Arrays.toString(arr));
		
	}
}
