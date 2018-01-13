import java.util.Scanner;


	
public class chooseMaster {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		for(int j = 0; j < a; j++) {
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println(getMaster(n, m)) ;
		}	
	
	}
	
	public static int getMaster(int n, int m) {
	    	Monkey firstMonkey = new Monkey(0);
			Monkey previousMonkey = firstMonkey;
			
			for(int i = 1; i < n; i++) {
				Monkey monkey = new Monkey(i);
				previousMonkey.setNext(monkey);
				monkey.setPre(previousMonkey);
				
				previousMonkey = monkey;
			}
			previousMonkey.setNext(firstMonkey);
			firstMonkey.setPre(previousMonkey);
			
	
			
			for( ; ; ) {
				if(firstMonkey.getNum() != firstMonkey.getNext().getNum()) {
					for(int i = 1; i < m; i++) {
						firstMonkey = firstMonkey.getNext();
					}
					firstMonkey = firstMonkey.getNext();
					firstMonkey.getPre().removeMonkey();
				}else {
					return firstMonkey.getNum();
				}
			}
	}
}
					
					
		