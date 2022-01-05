
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String encodedString){
        // code here
       Stack<Integer> stck = new Stack<Integer>();

		String decodedString = "";
		int lastClosedPairBracePos = -1;
		for (int i = 0; i < encodedString.length(); i++) {
			if (encodedString.charAt(i) == '[')
				stck.push(i);
			else if (encodedString.charAt(i) == ']') {
				int startPos = stck.pop();
				String extractedStr = getExtStr(encodedString.substring(startPos + 1, i));
				int times = findNumOftimes(encodedString, startPos - 1);

				String anyExtrawords = findExtraWords(encodedString, i);//3[a2[bd]g4[ef]h] for inputs like these
				if (startPos > lastClosedPairBracePos) {
					decodedString = decodedString + getWordByTimes(extractedStr, times) + anyExtrawords;
				} else {
					decodedString = getMultiplyWord(decodedString, extractedStr, times) + anyExtrawords;
				}
				lastClosedPairBracePos = startPos;
				//System.out.println(extractedStr + " " + times + " decodedString : " + decodedString);

			}
		}

		return decodedString;
	}

	private static String findExtraWords(String encodedString, int fromPos) {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		for (int i = fromPos + 1; i < encodedString.length(); i++) {
			if (Character.isDigit(encodedString.charAt(i)) || encodedString.charAt(i) == '['
					|| encodedString.charAt(i) == ']')
				break;
			if (Character.isLetter(encodedString.charAt(i))) {
				sb.append(encodedString.charAt(i));
			}
		}
		return sb.toString();
	}

	private static String getMultiplyWord(String decodedString, String extractedStr, int times) {
		StringBuffer sb = new StringBuffer(extractedStr + decodedString);
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < times; i++) {
			sb2.append(sb);
		}
		return sb2.toString();
	}

	private static String getWordByTimes(String word, int times) {
		StringBuffer sb = new StringBuffer();
		if (word.length() > 0) {
			for (int i = 0; i < times; i++) {
				sb.append(word);
			}
		}
		return sb.toString();

	}

	private static int findNumOftimes(String encodedString, int i) {
		StringBuffer sb = new StringBuffer();

		for (int j = i; j >= 0; j--) {
			if (Character.isDigit(encodedString.charAt(j))) {
				sb.insert(0, encodedString.charAt(j) + "");
			} else
				break;
		}
		return Integer.parseInt(sb.toString());
	}

	private static String getExtStr(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				sb.append(str.charAt(i) + "");
			} else
				break;
		}
		return sb.toString();
	}
}