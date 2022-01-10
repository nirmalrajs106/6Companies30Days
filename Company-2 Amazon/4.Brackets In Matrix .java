/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static class Pair{
        int cost;
        String format;
        
        Pair(int cost, String format){
            this.cost = cost;
            this.format = format;
        }
    }
    
    public static String getFormat(String mat1, String mat2){
        return "(" + mat1 + mat2 + ")";
    }
    
    public static Pair matMult(int[] mat, Pair[][] dp, int l, int r){
        
        if(r-l == 2){
            char mat1 = (char)(65+l);
            char mat2 = (char)(65+r-1);
            String format = getFormat(Character.toString(mat1), Character.toString(mat2));
            return new Pair(mat[l]*mat[l+1]*mat[r], format);
        }
        
        if(dp[l][r] != null){
            return dp[l][r];
        }
        
        int min = Integer.MAX_VALUE, cost;
        String format = "";
        String left = Character.toString((char)(l+65)), mat1;
        String right = Character.toString((char)(r+65-1)), mat2;
        for(int m=l+1; m<r; m++){
            
            mat1=left; mat2=right; cost=0;
            
            if(m-l > 1){
                Pair p = matMult(mat, dp, l, m);
                cost += p.cost;
                mat1 = p.format;
            }
            if(r-m > 1){
                Pair p = matMult(mat, dp, m, r);
                cost += p.cost;
                mat2 = p.format;
            }
            
            cost += mat[l] * mat[m] * mat[r];
            if(cost < min){
                min = cost;
                format = getFormat(mat1, mat2);
            }
        }
        
        
        return dp[l][r] = new Pair(min, format);
    }
    
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    String[] input = br.readLine().split("\\s");
		    
		    int[] mat = new int[n];
		    Pair[][] dp = new Pair[n][n];
		    for(int i=0; i<n; i++){
		        mat[i] = Integer.parseInt(input[i]);
		    }
		    
		    if(mat.length == 2)
		        System.out.println("A");
		    else      
		    	System.out.println(matMult(mat, dp, 0, n-1).format);
		}
	}
}
