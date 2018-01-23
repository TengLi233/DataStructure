import java.util.*;


public class DeleteCommit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = "";
		while(in.hasNextLine()) {
			s += in.nextLine();
		}
		in.close();
		System.out.println(s);
	}
}
