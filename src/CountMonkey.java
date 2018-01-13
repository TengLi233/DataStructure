import java.util.Scanner;

class Monkey{
	private int number;
	private Monkey next;
	private Monkey pre;
	
	public Monkey(int number) {
		this.number = number;
	}
	public void setNext(Monkey next) {
		this.next = next;
	}
	public void setPre(Monkey pre) {
		this.pre = pre;
	}
	public int getNum() {
		return this.number;
	}
	public Monkey getNext() {
		return this.next;
	}
	
	public Monkey getPre() {
		return this.pre;
	}
	public void removeMonkey() {
		this.pre.setNext(this.next);
		this.next.setPre(this.pre);
		
	}
}
	
	
public class CountMonkey {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr = new int[a];
		for(int j = 0; j < a; j++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
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
					arr[j] = firstMonkey.getNum();
					break;
				}
			}
			
		}	
		
		for(int x : arr) {
			System.out.println(x);
		}
		
	}
}
	
	
	
			
			
		
		
	

