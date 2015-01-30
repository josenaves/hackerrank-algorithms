import java.util.Random;

/*
 * We have a bag containing numbers 1, 2, 3, …, 100. Each number appears exactly once, so there are 100 numbers. 
 * Now one number is randomly picked out of the bag. Find the missing number.
 */
public class MissingNumber {
	static final int MAX = 100;
	
	public static void main(String[] args) {
		int numbers[] = new int[MAX];
		init(numbers);
		print(numbers);
		//numbers = randomRemove(numbers);
		numbers = randomRemoveWithoutShrink(numbers);
		print(numbers);
		System.out.println("Missing number :" + guess(numbers));
	}
	
	static int guess(int[] num) {
		int originalSum = (MAX * (1 + MAX)) / 2;
		int total = 0;
		for (int n : num) total += n;
		return originalSum - total;
	}
	
	static void init(int[] numbers) {
		int i = 0;
		int len = numbers.length;
		while (i < len) {
			numbers[i] = i + 1;
			i++;
		}
	}
	
	static int[] randomRemoveWithoutShrink(int[] num) {
		Random r = new Random(System.currentTimeMillis());
		num[r.nextInt(MAX)] = 0;
		return num;
	}

	
	static int[] randomRemove(int[] num) {
		Random r = new Random(System.currentTimeMillis());
		int i = r.nextInt(MAX);
		
		// create a new array
		int[] arr = new int[MAX-1];
		
		// copy the elements
		if (i == 0) {
			for (int j = i + 1; j < MAX; j++) arr[j-1] = num[j];
		}
		else if (i == MAX-1) {
			for (int j = 0; j < MAX-1; j++) arr[j] = num[j];
		}
		else {
			for (int j = 0; j < i; j++) arr[j] = num[j];
			
			for (int j = i + 1; j < MAX; j++) arr[j-1] = num[j];
		}
		return arr;
	}
	
	static void print(int[] arr) {
		for (int b : arr) System.out.print(b + " ");
		System.out.println();
	}
	

}
