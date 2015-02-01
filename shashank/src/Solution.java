import java.util.Scanner;

public class Solution {
    
    static int shashank(char[] arr) {
        int deleted = 0;
        
        int len = arr.length;
        if (len <= 1) return deleted;
        
        char previous = '0';
        for (int i = 0; i < len; i++) {
            if (arr[i] == previous) deleted++;
            
            previous = arr[i];
        }
        
        return deleted;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i=0; i < t; i++) {
        	String line = in.next();
            char[] arr = line.toCharArray();
            System.out.println(shashank(arr));
        }
    }
}