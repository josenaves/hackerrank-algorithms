import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        String[] words = new String[t];
        for (int i=0; i < t; i++) {
        	words[i] = in.nextLine();
        	System.out.println(makePalindrome(words[i].toCharArray()));
        }
        
        in.close();
    }
    
    static int makePalindrome(char[] word) {
    	if (checkPalindrome(word)) return 0;
    	
    	return 0;
    }

    static boolean checkPalindrome(char[] word) {
    	char[] rev = reverse(word);
    	return Arrays.equals(word, rev);
    }
    
    static char[] reverse(char[] word) {
    	int len = word.length;
    	char[] rev = new char[len];

    	int j = len-1;
    	for (int i = 0; i < len; i++) {
    		rev[j--] = word[i];
    	}
    	return rev;
    }
    
}
