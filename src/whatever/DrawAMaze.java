package whatever;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

	public Maze maze;
	int cellSize = 40;
	int startX = 10;
	int startY = 10;
	int width;
	int height;


	public Surface( Maze maze ) {

		this.maze = maze;
		this.width = maze.b * cellSize + 2 * startX;
		this.height = maze.a * cellSize + 2 * startY;
	}


	private void doDrawing( Graphics g ) {

		Graphics2D g2d = ( Graphics2D ) g;


		for ( int i = 0 ; i < maze.a ; i++ ) {
			for ( int j = 0 ; j < maze.b ; j++ ) {
				if(i==0){
					// draw also west walls
					if ( maze.isThereWestWall( i, j) ) {
						g2d.drawLine( startX , startY + j * cellSize , startX , startY + ( j + 1 )
								* cellSize );
					}
				}
				if(j==0){
					// draw also west walls
					if ( maze.isThereNorthWall( i, j) ) {
						g2d.drawLine( startX + i * cellSize, startY  , startX + (i +1) * cellSize , startY );
					}
				}
				if ( maze.isThereEastWall( i, j ) ) {
					g2d.drawLine( startX + ( i + 1 ) * cellSize , startY + j * cellSize , startX + ( i + 1 ) * cellSize , startY + ( j + 1 )
							* cellSize );
				}
				if ( maze.isThereSouthWall( i,j ) ) {
					g2d.drawLine( startX + ( i ) * cellSize , startY + ( j + 1 ) * cellSize , startX + ( i + 1 ) * cellSize , startY + ( j + 1 )
							* cellSize );
				}

				g2d.drawString( String.valueOf( maze.visited[ i ][ j ] ) , ( int ) ( startX + ( i + .5 ) * cellSize ) , ( int ) ( startY + ( j + .5 )
						* cellSize ) );
			}
		}

	}


	@Override
	public void paintComponent( Graphics g ) {

		super.paintComponent( g );
		doDrawing( g );
	}
}

public class DrawAMaze extends JFrame {

	public DrawAMaze() {

		initUI( );
	}


	private void initUI( ) {

		Maze maze = new Maze( 18 , 18 );
		maze.constructPath( );
		Surface s = new Surface( maze );
		add( s );

		setTitle( "Amazing Maze!" );
		setSize( s.width+10 , s.height+50 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}


	public static void main( String [ ] args ) {

		EventQueue.invokeLater( new Runnable( ) {

			@Override
			public void run( ) {

				DrawAMaze ex = new DrawAMaze( );
				ex.setVisible( true );
			}
		} );
	}
}