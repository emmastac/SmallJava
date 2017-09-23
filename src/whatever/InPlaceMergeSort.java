package whatever;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;


public class InPlaceMergeSort {
	
	public static void mergesort(ArrayList<Integer> A, int start, int end){
		int size = end - start;
		if( size==1 )
			return;
		int split =  start+ (size /2) ;
		
		mergesort(A, start, split);
		mergesort(A, split, end);
		
		merge(A, start, split, end);
		
	}
	
	
	
	public static void merge(ArrayList<Integer> A, int start, int split, int end){
		int i = start;
		int j = split;
		
		while( i<j && j<end){
			if( A.get(i) > A.get(j) ){
				A.add(i, A.remove( j ));
				i++; j++;
			}else{
				i++; 
			}
		}
		
	}


	
	
	public static void main(String[] args){
		
		ArrayList<Integer> A = new ArrayList<Integer>(5);
		A.addAll( Arrays.asList( new Integer[]{ 5, 4, 1, 3, 2 } ) );

		long start = getCpuTime();
		mergesort(A, 0, A.size());
		long end = getCpuTime();
		
		System.out.println( "cpu time :"+ (end - start) );
		System.out.println( A );
		
	}
	
	public static long getCpuTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    return bean.isCurrentThreadCpuTimeSupported( ) ?
	        bean.getCurrentThreadCpuTime( ) : 0L;
	}

}
