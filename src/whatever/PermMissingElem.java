package whatever;

import java.util.ArrayList;
import java.util.Collections;



public class PermMissingElem{
	
		public static void main(String[] args){
			PermMissingElem c = new PermMissingElem();
			
			System.out.println("solution: "+c.solution( c.generate(100000) ) );
		}
		
		public int[] generate(int N){
			ArrayList<Integer> al = new ArrayList<Integer>(N+1);
			for(int i=1; i<=N+1; i++){
				al.add( i );
			}
			
			Collections.shuffle( al );
			al.remove( 0 );
			
			int[] A = new int[N];
			for(int i=0; i<N; i++){
				A[i]=al.get( i );
			}
			return A;
		}
		
	    
	    
		public int solution(int A[]) {
	        // write your code in Java SE 8
			int N = A.length+1;
			int sum = 0;
			for(int i=0; i<A.length; i++){
				sum += A[i];
			}
			long l = (N)*(N+1); 
			return (int) ( l / (double) 2)-sum;
		
	    }
}
