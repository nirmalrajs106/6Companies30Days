//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.squaresInChessBoard(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long squaresInChessBoard(Long N) {
        // code here
       if(N==1) return (long)1;
        return (N*N)+squaresInChessBoard(N-1);
    }
};