import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code 
           String ans = "";
          int i =1;
          int count = 1 ;
          while(str.length()>i){
              
              if(str.charAt(i-1) == str.charAt(i)){
                  count++;
                  
              }else{
                  ans += str.charAt(i-1);
                  ans += count;
                  count = 1 ;
              }
              i++;
          }
           ans += str.charAt(i-1);
                  ans += count;
          
          return ans;
	}
	
 }
