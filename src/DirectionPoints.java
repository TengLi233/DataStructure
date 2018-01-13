import java.util.*;

class Point {
	int x, y, z;
	
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getZ() {
		return this.z;
	}
}

class Distance {
	double distance;
	Point p1;
	Point p2;
	
	public Distance(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		double temp = Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2);
		this.distance = Math.sqrt(temp);
	}
	public Point getP1() {
		return this.p1;
	}
	public Point getP2() {
		return this.p2;
	}
	
	
	public double getDistance() {
		return this.distance;
	}
}
public class DirectionPoints {
	public static void main(String[] args) {
		System.out.println("Please enter numbers: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		Point[] point = new Point[n];
		int[] coordinate = new int[n * 3];
		Distance[] distance = new Distance[(n * (n - 1)) / 2];
		
		for(int i = 0; i < coordinate.length; i++) {
			coordinate[i] = in.nextInt();
		}
		
		int e = 0;
		for(int i = 0; i < n; i++) {
			point[i] = new Point(coordinate[e], coordinate[e + 1], coordinate[e + 2]);

			e += 3;
		}
		
		int index = 0;
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n ; j++) {
				distance[index] = new Distance(point[i], point[j]);
				index++;
			}
		}
		
		for(int i = 0; i < distance.length - 1; i++) {
			for(int j = 0; j < distance.length - 1 - i; j++) {
				if(distance[j].getDistance() < distance[j + 1].getDistance()) {
					Distance temp = distance[j];
					distance[j] = distance[j + 1];
					distance[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < distance.length; i++) {
			String distanceLength = String.format("%4.2f", distance[i].getDistance());
			String distanceInfo = "(" + distance[i].getP1().getX() + "," + distance[i].getP1().getY() + "," + distance[i].getP1().getZ() + ")"
					+ "-" + "(" + distance[i].getP2().getX() + "," + distance[i].getP2().getY() + "," + distance[i].getP2().getZ() + ")"
					+ "=" + distanceLength;
			System.out.println(distanceInfo);
			
		}
		
		
		
	}

}
