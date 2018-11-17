import java.util.Arrays;
import java.util.Random;

public class IndexSort {
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr  = new int[1000];
		int minimum = -500;
		
		for ( int x = 0; x < 1000; x++ ) {
			int rand = minimum + ran.nextInt(500);
			arr[x] = rand;
		}
		
		long startTime = System.nanoTime();
		int[] sorted = sort(arr);
		long endTime = System.nanoTime();
		
		long myTime = (endTime - startTime);
		
		int[] new_arr = new int[1000];
		for ( int x = 0; x < 1000; x++ ) {
			int rand = ran.nextInt(1000);
			new_arr[x] = rand;
		}
		
		startTime = System.nanoTime();
		Arrays.sort(new_arr);
		endTime = System.nanoTime();
		
		long javaTime = (endTime - startTime);
		
		System.out.println("Index sort algorithim : " + myTime +"ns");
		System.out.println("Java's sort algorithim: " + javaTime +"ns");
		
		if ( myTime < javaTime ) {
			System.out.println("IndexSort is about " + (javaTime/myTime) + " times faster");
		} else {
			System.out.println("JavaSort is about " + (myTime/javaTime) + " times faster");
		}
	}
	
	public static int[] sort( int[] array ) {
		
		int max = array[0];
		int min = array[0];
		
		for ( int val : array ) {
		
			if ( val > max ) {
				max = val;
				
			}
			
			if (val < min ) {
				min = val;
			}
		
		}
	
		int placer;
		int[] indexing = new int[max - min + 1];
		
		for ( int val : array ) {

			placer = (-val)+max;
			indexing[placer]++;
		}
		
		int allVals = 0;
		int index = array.length - 1;
		int placeBack;
		int[] sorted = new int[array.length];
		
		while( allVals <= max - min ) {
			
			if( indexing[allVals] == 0 ) {
				
				allVals++;
				
			} else {
			
				placeBack = -(allVals - max);
			
				indexing[ allVals ] -= 1;
				sorted[ index ] = placeBack;
				index--;
			
			}
		}
		
		return sorted;
	}

}
