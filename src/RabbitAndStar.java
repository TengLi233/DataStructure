import java.util.Scanner;

class Edge {
	int from, to, weight;
	
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
class Vertex {
	char label;
	boolean wasVisited;
	
	public Vertex(char label) {
		this.label = label;
		this.wasVisited = false;
	}
}
class Graph {
	Vertex[] vertex;
	int[][] adjacency;
	int vertexNum;
	
	public Graph(int vertexNum) {
		this.vertexNum = vertexNum;
		this.vertex = new Vertex[vertexNum];
		adjacency = new int[vertexNum][vertexNum];
	}
	
}

public class RabbitAndStar {	
	public static void main(String[] args) {
		
		int max = 100;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Hello!");
		int a = in.nextInt();
		
		Graph g = new Graph(a);
		
		int[][] graph = g.adjacency;
		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a; j++) {
				graph[i][j] = max;
			}
		}
		
		for(int i = 0; i < a - 1; i++) {
			String vertex = in.next();
			int edgeNum = in.nextInt();
			int index = vertex.charAt(0) - 'A';
			for(int j = 0; j < edgeNum; j++) {
				String nextVertex = in.next();
				int weight = in.nextInt();
				int nextIndex = nextVertex.charAt(0) - 'A';
				graph[index][nextIndex] = weight;
			}
		}
	
		for(int[] x : graph) {
			for(int e : x) {
				System.out.print(e + " ");
			}
			System.out.println();
		}	
		
		
		
		
		
		int index = 0;
		int[] minEdge = new int[a - 1];
		int[] recordI = new int[a];
		int[] recordJ = new int[a];
		int sum = 0;
		
		for(int i = 0;i < 12; i++) {
			int[] arr = getMin(graph, a);
			if(index == a - 1) {
				break;
			}
			//System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
			if(judgeExist(recordI, recordJ, arr[0], arr[1])) {
				System.out.println(sum);
				recordI[arr[0]] = arr[0];
				recordJ[arr[1]] = arr[1];
				minEdge[index] = arr[2];
				sum += arr[2];
				index++;
			}
		}
		
		System.out.println(sum);
		
		
	}
		
	public static int[] getMin(int[][] graph, int a) {
		int minI = 0;
		int minJ = 0;
		int min = graph[minI][minJ];
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a; j++) {
				if(graph[i][j] < min) {
					//System.out.println(graph[i][j] + " " + min);
					minI = i;
					minJ = j;
					min = graph[i][j];
					
				}
			}
		}
		//System.out.println(min);
		graph[minI][minJ] = 100;
		int[] arr = {minI, minJ, min};
		return arr;
	}
	public static boolean judgeExist(int[] recordI, int[] recordJ, int I, int J) {
		boolean noExistI = true;
		boolean noExistJ = true;
		for(int i = 0; i < recordI.length; i++) {
			if(recordI[i] == I) {
				noExistI = false;
				break;
			}
		}
		for(int i = 0; i < recordJ.length; i++) {
			if(recordJ[i] == J) {
				noExistJ = false;
				break;
			}
		}
		return (noExistI && noExistJ);
	}
}
	
		
		

