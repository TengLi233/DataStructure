import java.util.*;

class Heap{
	private static final int DEFAULT_INITIAL_CAPACITY = 100000;
	private int[] heap;
	private int lastIndex;
	public Heap() {
		this.heap = new int[DEFAULT_INITIAL_CAPACITY];
	}
	public void add(int data) {
		this.lastIndex++;
	}
}


public class StackOperation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int m = in.nextInt();
			Heap h = new Heap();
			for(int j = 0; j < m; j++) {
				
			}
		}
	}

}
