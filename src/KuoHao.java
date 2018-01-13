import java.util.Scanner;

class StackOpe{
	private char[] data;
	private int top;
	
	public StackOpe() {
		this.data = new char[10000];
		this.top = 0;
	}
	
	public void addData(char c) {
		this.data[top] = c;
		this.top++;
	}
		
	public void deleteData() {
		this.data[top - 1] = 0;
		this.top--;
	}
	public char getData() {
		if(top - 1 >= 0)
			return this.data[this.top-1];
		else
			return 0;
	}
	
	public int getTop() {
		return top;
	}
}
public class KuoHao {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		StackOpe beauty = new StackOpe();
		beauty.addData(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) - beauty.getData() == 1 || s.charAt(i) - beauty.getData() == 2)
				beauty.deleteData();
			else
				beauty.addData(s.charAt(i));
		}
		
		if(beauty.getTop() == 0) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
		
	}

}
