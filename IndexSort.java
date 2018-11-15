import java.util.Arrays;
import java.util.Random;

public class IndexSort {
	
  // TODO indexing for negative values
  
	public static void main(String[] args) {
  
    // create new array with random values
		Random ran = new Random();
		int[] arr  = new int[1000];
    
		for ( int x = 0; x < 1000; x++ ) {
			int rand = ran.nextInt(900);
			arr[x] = rand;
		}
		
		long startTime = System.nanoTime();
    
		int[] sorted = sort(arr);
    
		long endTime = System.nanoTime();
		long myTime = (endTime - startTime);
    
    // randomize values for second test
		for ( int x = 0; x < 1000; x++ ) {
			int rand = ran.nextInt(900);
			arr[x] = rand;
		}
    
		startTime = System.nanoTime();
    
		Arrays.sort(arr);
    
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
    /* Find the max value */
		int max = array[0];
		for ( int val : array ) {
			if ( val > max ) {
				max = val;
			}
		}
    
    /* the max number of values to index held here
      because java initializes int array with 0
      we can increment by 1 */
     
		int[] indexing = new int[max + 1];
		for ( int val : array ) {
			indexing[val]++;
		}
    /* We have taken the input array and 
    incremeneted the values */
		int allVals = 0;
		int index = 0;
	
		int[] sorted = new int[array.length];
		while( allVals <= max ) {
			if( indexing[allVals] == 0 ) {
				allVals++;
			} else {

				indexing[ allVals ] -= 1;
				sorted[ index ] = allVals;
				index++;
			}
		}
		return sorted;
	}

}
