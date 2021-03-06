import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Rabbit {
	public static final int MAXCOST = 100;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[][] graph = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				graph[i][j] = MAXCOST;
			}
		}
		
		for(int i = 0; i < n - 1; i++) {
			int v1 = in.next().charAt(0) - 'A';
			int e = in.nextInt();
			for(int j = 0; j < e; j++) {
				int v2 = in.next().charAt(0) - 'A';
				int weight = in.nextInt();
				graph[v1][v2] = weight;
				graph[v2][v1] = weight;
			}
		}
		in.close();
		System.out.println(prim(graph, n));				
	}
	
	public static int prim(int[][] roadCost, int N) {
		boolean[] visited = new boolean[N];
		int sum = 0;
		int root = 0;
		visited[root] = true;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root);
		
		for(int edgeNum = 0; edgeNum < N - 1; edgeNum++) {
			int min = MAXCOST;
			int node = 0;
			for(int i = 1; i < N; i++) {
				if(visited[i] == false) {
					if(getMinCost(roadCost, list, i) < min) {
						min = getMinCost(roadCost, list, i);
						node = i;
					}
				}
			}
			visited[node] = true;
			list.add(node);
			
			if(min != MAXCOST)
				sum += min;
		}
		return sum;
	}  
	public static int getMinCost(int[][] roadCost, ArrayList<Integer> list, int i) {
		int min = MAXCOST;
		for(int x : list) {
			if(roadCost[i][x] < min) {
				min = roadCost[i][x];
				
			}
		}
		return min;
	}
	
}
