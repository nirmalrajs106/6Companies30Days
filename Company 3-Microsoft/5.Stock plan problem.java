import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends




class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
         int a[]=new int[n];
       Stack<Integer> st=new Stack<>();
       int c=0;
       for(int i=0;i<n;i++){
           if(st.size()==0)
              a[c++]=-1;
           else if(price[i]<price[st.peek()])
              a[c++]=st.peek();
           else if(price[i]>=price[st.peek()]){
               while(st.size()!=0 && price[i]>=price[st.peek()])
                 st.pop();
               if(st.size()==0)
                  a[c++]=-1;
               else
                  a[c++]=st.peek();
           }
           st.push(i);
       }
       for(int i=0;i<n;i++)
         a[i]=i-a[i];
       return a;
    }
    
}
