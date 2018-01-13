import java.util.*;

class TwoAryTree {
	private class Node {
		Node leftChild;
		Node rightChild;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	private Node root;
	private int depth;
	private int nodeNum;
	private Node[] node;
	
	public TwoAryTree(int num) {
		this.nodeNum = num;
		node = new Node[num];
		this.root = new Node(1);
		node[0] = this.root;
	}
}

public class BinaryTree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		TwoAryTree tree = new TwoAryTree(n);
		
		for(int i = 0; i < n; i++) {
			
		}
		
	}
}