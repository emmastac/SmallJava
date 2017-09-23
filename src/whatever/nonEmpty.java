package whatever;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class nonEmpty {

	public static void main( String [ ] args ) {

		nonEmpty c = new nonEmpty( );
		
		

		System.out.println( c.solution( c.randomGen(15) ) );
	}


	public int [ ] randomGen( int n ) {

		Random r = new Random( );
		r.setSeed( 900700 );

		int [ ] A = new int [ n ];

		List < Integer > positions = new ArrayList < Integer >( );
		for ( int i = 0 ; i < n ; i++ ) {
			positions.add( i );
		}
		
		//pick (n-1)/2 random integers
		// pick random places for them
		int pos;
		int randInt;
		while ( positions.size( )>1 ) {
			 randInt = (Math.abs(r.nextInt( )) % 1000001) + 1;
			
			 pos = (Math.abs(r.nextInt( )) % positions.size( ));
			 A[positions.get(pos)] = randInt;
			 positions.remove( pos );
			 
			 pos = (Math.abs(r.nextInt( )) % positions.size( ));
			 A[positions.get(pos)] = randInt;
			 positions.remove( pos );
		}
		
		A[positions.get( 0 )] = (Math.abs(r.nextInt( )) % 1000001) + 1;
		return A;

	}


	public int solution( int [ ] A ) {

		Arrays.sort( A );
		System.out.println( Arrays.toString( A ) );

		if ( A.length == 1 )
			return A[ 0 ];

		for ( int i = 1 ; i < A.length ; i = i + 2 ) {
			if ( A[ i ] != A[ i - 1 ] ) {
				return A[ i - 1 ];
			}
		}
		return A[A.length-1];
	}
	
	public int getIntegerInRange(int i, int k, boolean closedI, boolean closedK){
		
		Random r = new Random(3940490L);

		int to = r.nextInt( )%k ;
		if(closedK) to++;
		int from = to + i;
		if(closedI) from++;
		
		return from;
		
	}

}
