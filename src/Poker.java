import java.util.Scanner;

public class Poker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = in.next();
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length -1 -i; j++) {
				if(arr[j].charAt(0) > arr[j+1].charAt(0)) {
					String temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
				if(arr[j].charAt(0) == arr[j+1].charAt(0)) {
					if(arr[j].charAt(1) > arr[j+1].charAt(1)) {
						String temp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			System.out.print("Queue"+ i + ":");
			for(int j = 0; j < arr.length; j++) {
				int e = Integer.parseInt(arr[j].substring(1));
				if(e == i)
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		
		for(char i = 'A'; i <= 'D'; i++) {
			System.out.print("Queue"+ i + ":");
			for(int j = 0; j < arr.length; j++) {
				if(arr[j].charAt(0) == i)
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		
		for(String s : arr) {
			System.out.print(s + " ");
		}
	}
}
		
		
		
		
		
		
		
		
		
