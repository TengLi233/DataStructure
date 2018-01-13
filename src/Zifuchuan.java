import java.util.*;

public class Zifuchuan {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int e = 1; ; e++) {
			int n = in.nextInt();
			if(n == 0) {
				break;
			}
			String s = in.next();
			String[] preString = getPreString(s);
			System.out.println("Test case #" + e);
			for(int i = 1; i <= preString.length; i++) {
				int k = testString(preString[i - 1]);
				if(i%(i-k)==0 && i/(i-k) > 1) {
					System.out.println(preString[i - 1].length() + " " + i/(i-k));
				}
			}
			int k = testString(s);
			if(n%(n-k)==0 && n/(n-k) > 1) {
				System.out.println(n + " " + n/(n-k));
			}
		}
	}
	
	public static int testString(String s) {
		String[] preString = getPreString(s);
		String[] sufString = getSufString(s);
		
		for(int i = 0; i < preString.length; i++) {
			if(sufString[i].equals(preString[preString.length - 1 - i])) {
				return sufString[i].length();
			}
		}
		
		return 0;
	}
	
	public static String[] getPreString(String s) {
		String[] preString = new String[s.length() - 1];
		for(int i = 0; i < preString.length; i++) {
			preString[i] = s.substring(0, i+1);
		}
		return preString;
	}
	
	public static String[] getSufString(String s) {
		String[] sufString = new String[s.length() - 1];
		for(int i = 0; i < sufString.length; i++) {
			sufString[i] = s.substring(i+1, s.length());
		}
		return sufString;
	}

}
