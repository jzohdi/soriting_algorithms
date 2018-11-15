package sorting_algorithims;
import java.util.TreeMap;
import java.util.Random;

import java.util.Arrays;

class MutableInt {
	public int value = 1;
	public int decrease() {
		value--;
		return value;
	}
	public void increase() {
		value++;
	}
}

public class TreeSort {
	
	public static TreeMap<Integer, MutableInt> tree = new TreeMap<Integer, MutableInt>();
	
	public static void main(String[] args) {
//		System.out.println("here");
		Random ran = new Random();
		int[] arr  = new int[1000];
		for ( int x = 0; x < 1000; x++ ) {
			int rand = ran.nextInt(900);
			arr[x] = rand;
		}
		
		long startTime = System.nanoTime();
		int[] sorted = treeSort(arr);
		long endTime = System.nanoTime();
		long myTime = (endTime - startTime);
//		for ( int element : sorted ) {
//			System.out.println( element + ", " );
//		}
		for ( int x = 0; x < 1000; x++ ) {
			int rand = ran.nextInt(900);
			arr[x] = rand;
		}
		startTime = System.nanoTime();
		Arrays.sort(arr);
		endTime = System.nanoTime();
		long javaTime = (endTime - startTime);
		System.out.println((myTime/javaTime));
	}
		
	public static int[] treeSort( int[] array ) {
		int index = array.length - 1;
	
		int [] sorted = new int[array.length];
		for ( int element : array ) {
			add( element );
		}
		while( !( tree.isEmpty() ) ) {
			int value = getKey();

			sorted[index] = value;
			index--;
		}
		return sorted;
		
	}
	
	/* In testing a mutable object to increment or 
	 decrease value runs faster than other methods 
	 of changing int value for value key pair in map */
	
	public static void add( int ele ) {
		MutableInt val = tree.get( ele );
		if ( val == null ) {
			tree.put( ele , new MutableInt());
		}else {
			val.increase();
		}	
	}
	
	public static int getKey() {
		int element = tree.lastKey();
		MutableInt value = tree.get( element );
		value.decrease();
		if ( value.value == 0 ) {
			tree.remove( element );
		}
		return element;
	}
	
}
