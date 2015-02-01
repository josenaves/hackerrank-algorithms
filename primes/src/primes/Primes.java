package primes;

/*
 * Write a program which determines the sum of the first 1000 prime numbers.
 */
public class Primes {
    final static int MAX = 1000;
    final static int LIMIT = MAX*MAX;

	public static void main(String[] args) {
		sumPrimes(MAX);
	}

	static void sumPrimes(int n) {
		
		
		int[] primes = new int[MAX];
		
        boolean sieve[] = new boolean[LIMIT];
        
        // will remove numbers marked as true
        sieve[0] = sieve[1] = true; 
        
        int numPrimes = 0;
        while (numPrimes < MAX) {
            for (int i = 2; i <= LIMIT; i++) {
            	if (!sieve[i]) {
            		if (numPrimes == MAX) break;
            		primes[numPrimes++] = i;
            		
                	for (int j = 2*i; j < LIMIT; j+=i ) {
                		sieve[j] = true;
                	}
            	}
            }
        }
        
        long sum = 0;
        for (int i = 0; i < MAX; i++) {
    		sum += primes[i];
    		System.out.print(primes[i] + " ") ;
        }
        
		System.out.println() ;
		System.out.println(sum) ;
	}
	
}
