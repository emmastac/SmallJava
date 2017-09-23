package whatever;


public class TimeComplex {
	
		public static void main(String[] args){
			TimeComplex c = new TimeComplex();
			System.out.println("solution: "+c.solution(new int[]{-100, 100, 200}));
		}
		
	    
	    
		public int solution(int[] A) {
	        // write your code in Java SE 8
	        
	        int sum = 0;
	        for(int i=0; i<A.length; i++){
	            sum += A[i];
	        }
	        
	        int min = Integer.MAX_VALUE;
	        int left_sum = 0;
	        for(int i=1; i<A.length; i++){
	            
	            left_sum += A[i-1];
	            int diff = Math.abs(2*left_sum-sum); //bec. sum-left_sum
	            min = Math.min(min,diff);
		        System.out.println(diff);
	            if(min==0)
	                break;
	        }
	        
	        return min;
		}
}
