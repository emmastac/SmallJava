package whatever;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class MaxCounters{
	
		public static void main(String[] args){
			MaxCounters c = new MaxCounters();
			int[] A = {6,6,6,6,6,6};
			
			System.out.println("solution: "+Arrays.toString( c.solution( 5, new int[]{3,4,4,6,1,4,4} )) );
		}
		
		
	    
	    
		public int[] solution(int N, int[] A) {
			int[] sol= new int[N];
			
			int gMax = 0;
			
			for(int operation : A){
				// if max_counter
				if(operation==N+1){
					//reset all counters to gMax
					for(int i=0; i<N; i++){
						sol[i]=gMax;
					}
				}
					//if increase_X operation
				else{
					// increase counter and compare to max
					int counter = operation-1;
					sol[counter]++;
					gMax = Math.max( sol[counter] , gMax );
				}
			}
			
			return sol;
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
}
