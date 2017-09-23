package whatever;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Maze {

	public static int a;
	public static int b;


	public int [ ][ ] visited;

	public Maze( int a , int b ) {

		this.a = a;
		this.b = b;

		visited = new int [ a ] [ b ];
		for ( int i = 0 ; i < a ; i++ ) {
			Arrays.fill( visited[ i ] , -1 );
		}

	}


	public static void main( String [ ] args ) {

		Maze maze = new Maze( 4 , 4 );
		maze.constructPath( );
		maze.printOrder( );
		

	}



	public void printOrder( ) {

		for ( int i = 0 ; i < a ; i++ ) {
			for ( int j = 0 ; j < b ; j++ ) {
				System.out.print( visited[ i ][ j ] + " " );

			}
			System.out.println( );
		}
	}


	
	public boolean isThereSouthWall(int i, int j){
//		int i =c[0], j = c[1];
		if( j + 1 == b || Math.abs( visited[ i ][ j ] - visited[ i ][ j + 1 ] ) > 1 ){
			return true;
		}
		return false;
	}
	
	public boolean isThereNorthWall(int i, int j){
//		int i =c[0], j = c[1];
		if( j == 0 || Math.abs( visited[ i ][ j ] - visited[ i ][ j - 1 ] ) > 1 ){
			return true;
		}
		return false;
	}
	
	public boolean isExit(int i, int j){
		if(i+1==a && j+1==b){
			return true;
		}
		return false;
	}
	
	public boolean isEntrance(int i, int j){
		if(i==0 && j==0){
			return true;
		}
		return false;
	}
	
	public boolean isThereEastWall(int i, int j){
//		int i =c[0], j = c[1];
		if(isExit(i,j)){
			return false;
		}
		if(  i + 1 == a || Math.abs( visited[ i ][ j ] - visited[ i + 1][ j ] ) > 1 ){
			return true;
		}
		return false;
	}
	
	public boolean isThereWestWall(int i, int j){
//		int i =c[0], j = c[1];
		if(isEntrance(i,j)){
			return false;
		}
		if(  i == 0 || Math.abs( visited[ i ][ j ] - visited[ i - 1][ j ] ) > 1 ){
			return true;
		}
		return false;
	}


	public void constructPath( ) {

		ArrayList < int [ ] > stack = new ArrayList < int [ ] >( a * b );
		int c = 0;

		// add Start to the stack
		setCellAsNext2( stack , new int [ ] { 0 , 0 } , c++ );

		while ( stack.size( ) > 0 ) {
			int [ ] current = stack.get( 0 );

			int [ ] adj = pickAdjacent( current );
			if ( adj != null ) {
				setCellAsNext2( stack , adj , c++ );
				//removeWall(current, adj);
			} else {
				int[] rem = stack.remove( 0 );
				c = visited[rem[0]][rem[1]];
			}

		}
	}

	

	public void setCellAsNext( int [ ] adj , int c ) {

		visited[ adj[ 0 ] ][ adj[ 1 ] ] = c;
	}


	public void setCellAsNext2( ArrayList < int [ ] > stack , int [ ] adj , int c ) {

		visited[ adj[ 0 ] ][ adj[ 1 ] ] = c;
		stack.add( 0 , adj );
	}


	public int [ ] pickAdjacent( int [ ] a ) {

		ArrayList < int [ ] > options = new ArrayList < int [ ] >( 4 );
		// check if west cell is visited, if it exists
		int r = a[ 0 ], c = a[ 1 ];
		if ( r > 0 && visited[ r - 1 ][ c ] == -1 ) {
			options.add( new int [ ] { r - 1 , c } );
		}// same for east
		if ( r + 1 < this.a && visited[ r + 1 ][ c ] == -1 ) {
			options.add( new int [ ] { r + 1 , c } );
		}// same for north
		if ( c > 0 && visited[ r ][ c - 1 ] == -1 ) {
			options.add( new int [ ] { r , c - 1 } );
		}// same for east
		if ( c + 1 < this.a && visited[ r ][ c + 1 ] == -1 ) {
			options.add( new int [ ] { r , c + 1 } );
		}// same for east

		if ( options.size( ) == 0 ) {
			return null;
		}

		int rand = new Random( ).nextInt( options.size( ) );
		return options.get( rand );

	}


	public void fill( ) {

	}

}
