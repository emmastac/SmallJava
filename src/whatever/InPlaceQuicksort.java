package whatever;

import java.util.Arrays;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class InPlaceQuicksort {

	public static void quicksort ( int [ ] a , int start , int end ) {

		if ( end - start <= 1 ) {
			return;
		}

		// choose pivot
		int pivot = end - 1;

		// sort
		int wall = start - 1;
		for ( int j = start ; j < pivot ; j++ ) {
			if ( a [ j ] < a [ pivot ] ) {
				wall++;
				// System.out.print( a[i] +" "+a[j] +" ");
				swap( a , wall , j );
				// System.out.println( a[i] +" "+a[j] );
			}
		}
		wall++;
		// place pivot after wall
		swap( a , pivot , wall );
		
		// sort partitions
		quicksort( a , start , wall );
		quicksort( a , wall + 1 , end );
	}


	public static void swap ( int [ ] array , int a , int b ) {

		if ( a == b || a >= array.length || b >= array.length ) {
			return;
		}
		array [ a ] = array [ a ] + array [ b ];
		array [ b ] = array [ a ] - array [ b ];
		array [ a ] = array [ a ] - array [ b ];
	}


	public static void main ( String [ ] args ) {

		int [ ] unsorted = new int [ ] { 1 , 4 , 5 , 6 , 8 , 3 , 7 };

		quicksort( unsorted , 0 , unsorted.length );

		for ( int i : unsorted ) {
			System.out.print( i + ", " );
		}

	}

}
