import java.util.Scanner;

public class Judge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			int e = 0, k = 0;
			int m = in.nextInt();
			int[] arr1 = new int[1000];
			int[] arr2 = new int[1000];
			for(int j = 0; j < m; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				if(x == 1) {
					arr1[e] = y;
					e++;
				}else if (x == 2) {
					arr2[k] = y;
					k++;
				}
			}
			if(arr1[0] == arr2[0]) {
				System.out.println("Queue");
			}else {
				System.out.println("Stack");
			}
		}
					
	}

}
