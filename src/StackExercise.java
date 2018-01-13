import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;


public class StackExercise {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int m = in.nextInt();
			Stack<Integer> stack = new Stack<Integer>();
			for(int j = 0; j < m; j++) {
				String command = in.next();
				if(command.equals("push")) {
					int num = in.nextInt();
					stack.push(num);
				}else {
					try {
						stack.pop();
					}catch(EmptyStackException e) {
						System.out.println("Error");
					}
					
				}
			}
			
			if(stack.size() != 0) {
				int[] arr = new int[stack.size()];
				
					
				for(int x = arr.length - 1; x >= 0; x--) {
					arr[x] = stack.pop();
				}
				
				for(int x : arr) {
					System.out.print(x + " ");
					
				}
			}
		}
		
	}
	
}
		
	
