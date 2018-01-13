import java.util.*;

public class Zhongweishu {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < (n / 2) + 1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		System.out.println(array[(n/2)]);
	}

}
