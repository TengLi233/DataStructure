import java.util.*;

public class BuildARoad {
	public static final int MAXCOST = 10010;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		
		int[][] roadCost = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cost = in.nextInt();
				if(cost != 0)
					roadCost[i][j] = cost;
				else
					roadCost[i][j] = MAXCOST;
			}
		}
		
		System.out.println(Prim(roadCost, N));
	}
	
	public static int Prim(int[][] roadCost, int N) {
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
		//System.out.println(min);
		return min;
	}
}
		
		
		
		
