import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        long ugly[]=new long[n];
        ugly[0]=1;
        int two=0;
        int three=0;
        int five=0;
        for(int i=1;i<n;i++){
            long next=Math.min(Math.min(ugly[two]*2,ugly[three]*3),ugly[five]*5);
            ugly[i]=next;
        
        if(next==ugly[two]*2) two++;
        if(next==ugly[three]*3) three++;
        if(next==ugly[five]*5) five++;
        }
        return ugly[n-1];
    }
}
