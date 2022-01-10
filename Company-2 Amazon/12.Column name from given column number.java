//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        StringBuffer sb=new StringBuffer();
        while(n>0){
            sb.append(charOf(n%26));
            n=(n-1)/26;
        }
        sb .reverse();
        return(sb.toString());
    }//colName
    public char charOf(long val){
        if(val==0)
            return('Z');
        else
            return((char)(64+val));
    }
}
