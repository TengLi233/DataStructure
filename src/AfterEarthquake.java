import java.util.*;

class Village {
	int x,y;
	boolean visited;
	ArrayList<Village> next;
	
	public Village(int x, int y) {
		this.x = x;
		this.y = y;
		this.visited = false;
		this.next = new ArrayList<Village>();
	}
	
	public double getDistance(Village other) {
		return Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2));
	}
}
public class AfterEarthquake {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			
			Village[] v = new Village[N];
			for(int i = 0; i < N; i++) {
				v[i] = new Village(in.nextInt(), in.nextInt());
			}
			for(int i = 0; i < M; i ++) {
				v[in.nextInt() - 1].next.add(v[in.nextInt() - 1]);
			}
			double sum = 0;
			for(int c = 0; c < N -1; c++) {
				double minDistance = 10000;
				v[0].visited = true;
				if(v[0].next.size() == 1 && !v[0].next.get(0).visited) {
					v[0].next.get(0).visited = true;
					sum += v[0].getDistance(v[0].next.get(0));
				}
				int index1 = 0;
				int index2 = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < v[i].next.size(); j++) {
						if(v[i].getDistance(v[i].next.get(j)) < minDistance && !v[i].next.get(j).visited) {
							minDistance = v[i].getDistance(v[i].next.get(j));
							index1 = i;
							index2 = j;
						}
					}
				}
				v[index1].next.get(index2).visited = true;
				if(v[index1].next.get(index2).next.contains(v[index1])) {
					v[index1].visited = true;
				}
				if(minDistance != 10000) {
					sum += minDistance;
				}					
			}
			boolean allContains = true;
			for(Village x : v) {
				if(x.visited == false) {
					allContains = false;
					break;
				}
			}
			if(allContains) {
				System.out.println(String.format("%.2f", sum));
			}else {
				System.out.println("NO");
			}
		}
	}

}
