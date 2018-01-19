import java.util.*;

public class Paidui {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i = 0; i < T; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			
			for(int j = 0; j < m; j++) {
				int l = in.nextInt();
				int r = in.nextInt();
				System.out.println(getMinTime(arr, l, r));
			}
		}
	
		in.close();
	}
	
	public static int getMinTime(int[] arr, int l, int r) {
		int[] tempArray = arr.clone();
		sortArray(tempArray, l - 1, r - 1);
		int minTime = 0;
		int temp = 0;
		temp = tempArray[l - 1];
		minTime += temp;
		for(int i = l; i <= r - 1; i++) {			
			temp += tempArray[i];
			minTime += temp;
		}
		return minTime;
			
	}
	
	public static void sortArray(int[] arr, int lo, int hi) {
		if(hi - lo <= 14) {
			for(int i = lo + 1; i <= hi; i++) {
				int temp = arr[i];
				int j = i;
				while(j > 0 && temp < arr[j - 1]) {
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = temp;
			}
			return;
		}
		
		int key = arr[lo];
		int start = lo;
		int end = hi;
		while(start < end) {
			while(arr[end] >= key && start < end) {
				end--;
			}
			if(arr[end] < key) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			while(arr[start] < key && start < end) {
				start++;
			}
			if(arr[start] > key) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		if(start > lo)
			sortArray(arr, lo, start - 1);
		if(end < hi)
			sortArray(arr, end + 1, hi);
	}
}
			
		

