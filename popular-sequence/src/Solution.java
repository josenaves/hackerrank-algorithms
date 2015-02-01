import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Solution {

	
	/*********************
	 *
	 * 1. Explain your approach:
	 *  
	 * I've stored all the information read from the log into a LinkedHashSet
	 * where the customer ID is the key and the data is an ArrayList of PageTypes
	 * 
	 * Next, I try to find a repeating pageType pattern accross the customers.
	 * I use the "Longest common substring" (LCS) algorithm to solve this.
	 * 
	 * Once found I return the solution.
	 * 
	 * 2. What is the big-O runtime of your approach:
	 *
	 */
	
	public static class LogLine {
		public long timestamp;
		public String customerId;
		public String pageType;
	}

	List<String> mostPopularThreePageSequence(List<LogLine> logFileInput) {
	
		// Using LinkedHashMap since it preserves the insertion order
		// Idem to ArrayList
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String,  ArrayList<String>>();
		
		// Fill the map
		for (LogLine line : logFileInput) {
			
			ArrayList<String> list = map.get(line.customerId);
			if (list != null) {
				// insert another element in the list
				list.add(line.pageType);
			}
			else {
				list = new ArrayList<String>();
				list.add(line.pageType);
				map.put(line.customerId, list);
			}
		}
		
		// try to find 3 page patterns
		
		return null;
	}

	
	static String findLcs(String s1, String s2) {
		
		int longest = 0;
		
        int len1 = s1.length();
        int len2 = s2.length();
 
        int[][] lcs = new int[len1 + 1][len2 + 1];
 
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
            	
            	if (i == 0 || j ==0) lcs[i][j] = 0;
            	else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                	lcs[i][j] = lcs[i-1][j-1] + 1;
                	if (lcs[i][j] > longest)  {
                		longest = lcs[i][j];
                	}
                }
                else {
                	lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        System.out.println("longest = " + longest);
        
        // get the string sequence
        String sequence = "";
        
        int auxLongest = longest;
        
        for (int i = len1; i > 0; i--) {
        	// search the index of the longest sequence
        	int[] row = lcs[i];
        	
        	for (int j = len2; j >= 0; j--) {
        		if (row[j] == auxLongest) {
        			sequence += s2.charAt(j-1);
        			auxLongest--;
        		}
        		else {
        			auxLongest = longest;
        			sequence = "";
        		}
        	}
        }
        
        return sequence;
    }

	
	
	
	private static List<LogLine> getLog() {
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		List<LogLine> log = new ArrayList<LogLine>();
		
		String line;
		try {
			while (inReader.ready() && (line = inReader.readLine()) != null) {
				String[] logLineTokens = line.split(" ");
				LogLine logLine = new LogLine();
				logLine.timestamp = Long.parseLong(logLineTokens[0]);
				logLine.customerId = logLineTokens[1];
				logLine.pageType = logLineTokens[2];
				log.add(logLine);
			}
		} 
		catch (IOException e) {
			return null;
		}
		return log;
	}
	
	public static void main(String[] args) {
		
		System.out.println(findLcs("GSD", "GGSDD"));
		System.out.println(findLcs("juliana", "mariana"));
		System.out.println(findLcs("mariajuliana", "mariana"));

		System.exit(0);
		
		List<LogLine> log = getLog();
		List<String> mostPopularSequence = new Solution().mostPopularThreePageSequence(log);
		
		if (mostPopularSequence != null && !mostPopularSequence.isEmpty()) {
			for (String pageInSequence : mostPopularSequence) {
				System.out.println(pageInSequence);
			}
		} 
		else {
			System.out.println("no sequence found");
		}
	}

}