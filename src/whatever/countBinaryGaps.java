package whatever;


public class countBinaryGaps {
	
		public static void main(String[] args){
			countBinaryGaps c = new countBinaryGaps();
			System.out.println(c. solution(5675328));
		}
	    
	    
	    public int solution(int N) {
	        long beg = System.currentTimeMillis( );
	        //String x = "";
	        int max = 0;
	        int curr = -1;
	        int last1 = Integer.MAX_VALUE;
	        
	         while (N > 0 ){
	             
	             int newN =  N/2;
	             int bit = N %2;
	             N  = newN;
		            
	             curr++;
	           
	            if(bit==1){
	                int gap = curr - last1 -1;
	                max = Math.max(gap,max);  
	                last1 = curr;
	            }

		           

	           // x=bit+x;
	        }    
	        
	       // System.out.println(x);
	         long end = System.currentTimeMillis( );
	         System.out.println("time ="+ String.valueOf(end-beg));
	        return max;
	    }

}
