import java.util.Scanner;

class Location {
	String name;
	boolean mark;

	public Location(String name) {
		this.name = name;
		this.mark = false;
		
	}
}
public class Sakura {
	
	public static Location[] S ;
	public static Location[] U ;
	public static int[] minLength ;
	
	public static void main(String[] args) {
		System.out.println("Hello!");
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		Location[] location = new Location[vertexNum];
		int[][] adjacency = new int[vertexNum][vertexNum];
		
		S = new Location[vertexNum];
		U = new Location[vertexNum];
		minLength = new int[vertexNum];
		

		
		for(int i = 0; i < vertexNum; i++) {
			location[i] = new Location(in.next());
		}
		
		int edgeNum = in.nextInt();
		
		for(int i = 0; i < edgeNum; i++) {
			int a = getIndex(location, in.next());
			int b = getIndex(location, in.next());
			int weight = in.nextInt();
			
			adjacency[a][b] = weight;
			adjacency[b][a] = weight;
		}
		
		int wayNum = in.nextInt();
		
		for(int i = 0; i < wayNum; i++) {
			String a = in.next();
			String b = in.next();
			
			for(int j = 0; j < location.length; j++) {
				minLength[j] = 100;
			}
			minLength[getIndex(location, a)] = 0;
			
			Dijkstra(adjacency, location, getIndex(location, a), getIndex(location, b));
			//System.out.print(minLength[getIndex(location, b)]);
		}
		
//		for(int[] x : adjacency) {
//			for(int e : x) {
//				System.out.print(e + " ");
//			}
//			System.out.println();
//		}	
	}
	
	public static int getIndex(Location[] location, String place) {
		int i = 0;
		for( ;i < location.length; i++) {
			if(location[i].name.equals(place)) {
				return i;
			}
		}
		return i;
	}
	
	public static int Dijkstra(int[][] adjacency, Location[] location,int s, int e) {
		
		location[s].mark = true;
		System.out.print(location[s].name);
		if(s == e) {
			
			 return 0;
		} else {
			
					
			for(int j = 0; j < location.length; j++) {
				if(adjacency[s][j] != 0 && location[j].mark == false) {
					location[j].mark = true;
					if(j == e) {
						minLength[e] = adjacency[s][j];
						System.out.print("->(" + adjacency[s][e] + ")->" + location[j].name);
						break;
					}else {
						System.out.print("->(" + adjacency[s][j] + ")->" );
						int min = adjacency[s][j] + Dijkstra(adjacency, location, j, e);
						if(min < minLength[e]) {
							minLength[e] = min;
							
						}
					}				
				}
			}
			return minLength[e];
		}		
	}
}
//for(int i = 0; i < location.length; i++) {
//if(adjacency[s][i] != 0) {
//	location[i].mark = true;
//	minLength[i] = adjacency[s][i];
////	System.out.print(location[s].name + "->(" + adjacency[s][e] + ")->" );
////	return;				
//}else {
//	U[i] = location[i];
//}
//}
			
		
			
		

