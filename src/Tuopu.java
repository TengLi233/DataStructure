import java.util.*;

class Digraph {
	int vertexNum;
	int edgeNum;
	Vertice[] vertex;
	public Digraph(int vertexNum) {
		this.vertexNum = vertexNum;
		this.vertex = new Vertice[vertexNum];
		for(int i = 0; i < vertexNum; i++) {
			vertex[i] = new Vertice(i + 1);
		}
	}
	public void addEdge(int v, int w) {
		
		vertex[v - 1].next.add(vertex[w - 1]);

		vertex[w - 1].indegree++;
	}
}
class Vertice {
	int number;
	int indegree;
	ArrayList<Vertice> next;
	boolean visited;
	public Vertice(int number) {
		this.number = number;
		this.indegree = 0;
		this.next = new ArrayList<Vertice>();
		this.visited = false;
	}
}
public class Tuopu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();
		
		ArrayList<Integer> tuopu = new ArrayList<Integer>();
		
		Digraph d = new Digraph(V);
		
		for(int i = 0; i < E; i++) {
			d.addEdge(in.nextInt(), in.nextInt());
		}
		
		for(int i = 0; i < V; i++) {
			if(d.vertex[i].indegree == 0 && d.vertex[i].visited == false) {
				d.vertex[i].visited = true;
				tuopu.add(d.vertex[i].number);
				subIndegree(d.vertex[i] , d, tuopu);
			}
		}
		
		for(int i = 0; i < tuopu.size(); i++) {
			System.out.print("v" + tuopu.get(i) + " ");
		}
	}
	
	public static void subIndegree(Vertice v, Digraph d, ArrayList<Integer> tuopu) {
		for(int j = 0; j < v.next.size(); j++) {
			v.next.get(j).indegree--;
			if(v.next.get(j).indegree == 0 && v.next.get(j).visited == false) {
				v.next.get(j).visited =true;
				tuopu.add(v.next.get(j).number);
				subIndegree(v.next.get(j), d, tuopu);
			}
		}
	}

}
