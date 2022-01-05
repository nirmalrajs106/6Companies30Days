//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        // code here
        char[] digits=str.toCharArray();
int n=digits.length;
int[] count=new int[n+1];

count[0]=1;
count[1]=1;

if(digits[0]=='0')
return 0;

for(int i=2;i<=n;i++)
{
count[i]=0;

if(digits[i-1]>'0')
count[i]=count[i-1];

if(digits[i-2]=='1' || (digits[i-2]=='2' && digits[i-1]<'7'))
count[i]=(count[i]%1000000007+count[i-2]%1000000007)%1000000007;
}
return count[n];
    }
}