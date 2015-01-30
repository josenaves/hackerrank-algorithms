package fizzbuzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
16 10 43
1 5 40
15 3 66
13 17 30
4 8 30
13 15 73
2 10 29
15 7 30
18 8 90
17 15 97
19 1 29
9 15 54
9 20 44
16 12 87
2 13 74
13 3 37
6 7 29
18 1 84
16 20 49
2 19 33
 */
public class FizzBuzz {

	public static void main(String[] args) throws IOException {
		String line = "16 10 43";
		String[] input = line.split(" ");

		System.out.println(
				fizzBuzz(
						Integer.parseInt(input[0]),
						Integer.parseInt(input[1]), 
						Integer.parseInt(input[2])
					)
				);
	}

	static String fizzBuzz(int x, int y, int n) {
		StringBuffer response = new StringBuffer();

		for (int i = 1; i <= n; i++) {
			String resp = "";

			boolean fizz = (i % x == 0);
			boolean buzz = (i % y == 0);

			if (fizz && buzz)
				resp = "FB";
			else if (fizz)
				resp = "F";
			else if (buzz)
				resp = "F";
			else
				resp = String.valueOf(i);

			response.append(resp).append(" ");
		}

		return response.toString().trim();
	}
}
