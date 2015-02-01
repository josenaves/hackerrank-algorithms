import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    static int min(int[] cadies) {
    	int minimum = Integer.MAX_VALUE;
    	for (int e : cadies) if (e <= minimum) minimum = e;
    	return minimum;
    }

    static int max(int[] cadies) {
    	int maximum = Integer.MIN_VALUE;
    	for (int e : cadies) if (e >= maximum) maximum = e;
    	return maximum;
    }
    
    static void print(int[] arr) {
    	String aux = "";
    	for (int i : arr) aux = aux + " " + i;
    	System.out.println(aux);
    }

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] list = new int[n];
        for (int i=0; i < n; i++) {
        	list[i] = in.nextInt();
        }
        
        Arrays.sort(list);

        int[] cadies = new int[k];
        for (int i=0; i < k; i++) {
        	cadies[i] = list[i];
        }

        System.out.println(max(cadies) - min(cadies));
    }
}