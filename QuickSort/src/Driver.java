
public class Driver {
	public static void main( String[] args ) {
		int[] startingArray = new int[] {17, 41, 5, 22, 54, 6, 29, 3, 13};
		int[] sortedArray = Quicksort.quicksort( startingArray );
		for ( int x = 0; x < sortedArray.length; x++ ) {
			System.out.print( sortedArray[ x ] + " ");
		}
	}
}
