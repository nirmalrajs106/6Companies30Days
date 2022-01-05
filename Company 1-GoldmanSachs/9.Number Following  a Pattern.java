//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String s){
        // code here
        Stack<Integer> st = new Stack<>();
        String ans = "";
        int num = 1;
        st.push(num);
        for(int i = 0; i < s.length(); i++){
             char c = s.charAt(i);
             if( c == 'D' ){
                 st.push( ++num );
              }else{
                   while( st.size() > 0 ){
                         ans += st.pop();
                    }
                st.push( ++num );
              }
        }
           while( st.size() > 0 ){
                      ans += st.pop();
           }
        return ans;

    }
}
