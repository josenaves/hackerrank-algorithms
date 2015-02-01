import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int missing(int[] numbers) {
		int total = numbers.length + 1;
		
		int sum = total * (numbers[0] + numbers[numbers.length-1])/2 ;
		
		int sum2 = 0;
		for (int n : numbers) sum2+=n;
		
		return sum - sum2;
	}
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    
	    in.nextLine();
	    
	    String aux = in.nextLine();
	    String[] sNumbers = aux.split(" ");
	    int[] numbers = new int[t];
	    
	    int i = 0;
	    for (String num : sNumbers) numbers[i++] = Integer.parseInt(num);

	    System.out.println(missing(numbers));
	}
	
}
