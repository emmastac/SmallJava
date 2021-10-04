package whatever;

import java.util.ArrayList;
import java.util.Arrays;

import whatever.Trees.IntervalNode;
import whatever.Trees.Node;


public class AlberHallConcerts {
	
	public static void main( String [ ] args ) {

		int N = 365;
		boolean [ ] calendar = new boolean [ N ];
		Arrays.fill( calendar , false );

		int pending = 10;
		int d = 4;
	}
	
	public class Calendar{
		
		IntervalNode root;
		
		public Calendar(){
			root = new IntervalNode();
			root.d0 = 0;
			root.d1 = 365;
		}
		
		public IntervalNode findNode(int d){
			IntervalNode n = root;
			while( true ){
				if(( (IntervalNode) n.left).d0 < d && ( (IntervalNode) n.right).d0 < d)
				return n;
			
			else if( ( (IntervalNode) n.left).d0 > d) {
				return findNode( d);
			}}
		}
		
		public IntervalNode findNextNode(int d){
			
			IntervalNode n = root;
			
			if( ( (IntervalNode) n.left).d0 < d && ( (IntervalNode) n.right).d0 < d ){
				return n;
			}
			return null;
		}
	}
	
	public class IntervalNode {

		public IntervalNode left;
		public IntervalNode right;
		public IntervalNode parent;
		public int d0;
		public int d1;

		public int compare( IntervalNode n ) {

			int there =  n.left.d0;
			int here = this.left.d0;
			return ( here - there );
		}
		
		public int compareStart( IntervalNode n ) {
			
			return compare(n);
		}
		
		public int contains( IntervalNode n ) {

			int there =  n.left.d0;
			int here = this.left.d0;
			return ( here - there );
		}
	}
}
