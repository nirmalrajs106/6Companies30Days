//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	      int sum=0;
    for(int i=0;i<n;i++)
        sum+=arr[i];
    ArrayList<Integer> ele=subsetsum(arr,sum,n);
    int min=Integer.MAX_VALUE;
    for(int i=0;i<ele.size();i++)
    {
        min=Math.min(min,sum-2*ele.get(i));
    }
    return min;
} 
public ArrayList<Integer> subsetsum(int arr[],int sum,int n)
{
    boolean dp[][]=new boolean[n+1][sum+1];
    for(int i=0;i<=sum;i++)
        dp[0][i]=false;
    for(int i=0;i<=n;i++)
        dp[i][0]=true;
         for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=sum;j++)
        {
            if(arr[i-1]<=j)
                dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
            else
                dp[i][j]=dp[i-1][j];
        }
    }
    ArrayList<Integer> half=new ArrayList<>();
    for(int i=0;i<=sum/2;i++)
    {
        if(dp[n][i])
            half.add(i);
    }
    return half;

	} 
}
