import java.util.Scanner;

public class Solution {
    
    static String pangram(char[] phrase) {
    	
    	String result = "pangram";

    	char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    	int alphaLen = alphabet.length;

    	if (phrase.length < alphaLen) return "not " + result;
    	
    	int count[] = new int[alphaLen];
    	for (int i = 0; i < alphaLen; i++) {
    		char letter = alphabet[i]; 
    		for (int j = 0; j < phrase.length; j++) {
    			if (letter == phrase[j]) {
    				count[i] = 1;
    				break;
    			}
    		}
    	}
    	
    	for (int i = 0; i < alphaLen; i++) {
    		if (count[i] == 0) return "not " + result;
    	}

    	return result;
    }

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.toLowerCase();
        s = s.replaceAll("\\s","");
        
        int n = s.length();
        
        char[] phrase = new char[s.length()];
        for (int i=0; i < n; i++) {
        	phrase[i] = s.charAt(i);
        }

        System.out.println(pangram(phrase));
    }
}