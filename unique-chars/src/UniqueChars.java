/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 * Considering ASCII 'alphabet'.
 */
public class UniqueChars {

	static final int MAX = 256;
	
	public static void main(String[] args) {
		String t1 = "12342353463";
		System.out.println(unique(t1.toCharArray()));
		
		String t2 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(unique(t2.toCharArray()));
	}
	
	static boolean unique(char[] str) {
		int len = str.length;
		if (len > MAX) return false;
		
		boolean[] presence = new boolean[MAX];
		
		int i = 0;
		while (i < len) {
			if (presence[ str[i] ]) return false;
			
			presence[ str[i] ] = true;
			i++;
		}
		return true;
	}
	

}