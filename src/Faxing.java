import java.util.*;
public class Faxing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long temp = 0;
		long cow = 0;
		long [] arr = new long[(int) n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
					
		}
		
		for(int i = 0; i < arr.length; i++) {
			long singlecow = 0;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[i]) {
					singlecow++;
				}else {
					break;
				}
			}
			cow += singlecow;
		}
		
		System.out.println(cow);
	}	
}
			 
			
			
			
			
			
		

