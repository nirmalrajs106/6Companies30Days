import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int K = Integer.parseInt(S[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.findPosition(N,M,K));
        }
    }
}
class Solution {
    static int findPosition(int N , int M , int K) {
       
       if(N==1)
       {
           return 1;
       }
       
       int ans = M%N+K-1;
       if(ans==N)
       {
           return ans;
       }
       
       return ans%N;
    }
};
