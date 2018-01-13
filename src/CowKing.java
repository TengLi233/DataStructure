import java.util.*;

public class CowKing {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		long[] arr1 = new long[n];
		long[] arr2 = new long[n];
		
		int[] helpArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr1[i] = in.nextLong();
			arr2[i] = in.nextLong();
			helpArr[i] = i;
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if(arr1[j] < arr1[j+1]) {
					int temp = helpArr[j];
					helpArr[j] = helpArr[j + 1];
					helpArr[j + 1] = temp;	
					
					long temp1 = arr1[j];
					arr1[j] = arr1[j + 1];
					arr1[j + 1] = temp1;
				}
			}
		}
		
		long[] finalArr = new long[k];
		
		for(int i = 0; i < k; i++) {
			finalArr[i] = arr2[helpArr[i]];
		}
		
		int max = 0;
		for(int i = 1; i < k; i++) {
			if(finalArr[i] > finalArr[max]) {
				max = i;
			}
		}

		
		System.out.print(helpArr[max] + 1);
		
	
	
	}

}
