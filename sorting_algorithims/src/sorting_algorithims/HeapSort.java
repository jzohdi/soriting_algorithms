package sorting_algorithims;
import java.util.Random;

public class HeapSort {
	
	public int[] sort( int array[]) {
		
		int n = array.length;
		
		for ( int index = n /2 - 1; index >= 0; index-- ) {
			heapify(array, n, index);
		}
		
		for ( int index = n - 1; index >= 0; index-- ) {
			int temp = array[0];
			array[0] = array[ index ];
			array[ index ] = temp;
			
			heapify(array, index, 0);
			
		}
		return array;
	}
	
	void heapify(int array[], int n, int index) {
		
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		
		if ( left < n && array[ left ] > array[ largest ] ) {
			largest = left;
		}
		
		if ( right < n && array[ right ] > array[ largest ] ) {
			largest = right;
		}
		
		if ( largest != index ) {
			int temp = array[ index ];
			array[ index ] = array[ largest ];
			array[ largest ] = temp;
			
			heapify(array, n, largest);
		}
		
	}
	
	public static void main(String args[]) {
		int[] array= new int[ 25 ];
		Random rand = new Random();
		for ( int x = 0; x < 25; x++ ) {
			array[x] = rand.nextInt(100);
		}
		
		HeapSort heapSort = new HeapSort();
		array = heapSort.sort( array );
		for ( int y = 0; y < array.length; y++ ) {
			System.out.print( array[ y ]+"/" );
		}
		
	}

}
