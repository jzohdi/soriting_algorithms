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
	
	public static TreeMap<Comparable, MutableInt> tree = new TreeMap<Comparable, MutableInt>();
	
	public static void main(String[] args) {
//		System.out.println("here");
		String allChars = "abcdefghijklmnopqrstuvwxyzABSCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random ran = new Random();
		String[] arr  = new String[1000];
		for ( int x = 0; x < 1000; x++ ) {
			StringBuilder newString = new StringBuilder();
			int randomLength = ran.nextInt(20) + 1;
			for ( int y = 0; y < randomLength; y++ ) {
				int randomL = ran.nextInt(allChars.length());
				newString.append( allChars.charAt( randomL ) );
			}
			arr[x] = newString.toString();
		}
		
		long startTime = System.nanoTime();
		Comparable[] sorted = treeSort(arr);
		long endTime = System.nanoTime();
		
		long myTime = (endTime - startTime);
		
//		for ( String element : sorted ) {
//			System.out.println( element + ", " );
//		}
		
		for ( int x = 0; x < 1000; x++ ) {
			StringBuilder newString = new StringBuilder();
			int randomLength = ran.nextInt(20) + 1;
			for ( int y = 0; y < randomLength; y++ ) {
				int randomL = ran.nextInt(allChars.length());
				newString.append( allChars.charAt( randomL ) );
			}
			arr[x] = newString.toString();
		}
		
		startTime = System.nanoTime();
		Arrays.sort(arr);
		endTime = System.nanoTime();
		
		long javaTime = (endTime - startTime);
		System.out.println("Tree sort algorithim : " + myTime +"ns");
		System.out.println("Java's sort algorithim: " + javaTime +"ns");
		
		if ( myTime < javaTime ) {
			System.out.println("IndexSort is about " + (javaTime/myTime) + " times faster");
		} else {
			System.out.println("JavaSort is about " + (myTime/javaTime) + " times faster");
		}
	}
		
	public static Comparable[] treeSort( String[] array ) {
		int index = array.length - 1;
	
		Comparable [] sorted = new Comparable[array.length];
		for ( Comparable element : array ) {
			add( element );
		}
		while( !( tree.isEmpty() ) ) {
			Comparable value = getKey();

			sorted[index] = value;
			index--;
		}
		return sorted;
		
	}
	public static void add( Comparable ele ) {
		MutableInt val = tree.get( ele );
		if ( val == null ) {
			tree.put( ele , new MutableInt());
		}else {
			val.increase();
		}	
	}
	
	public static Comparable getKey() {
		Comparable element = tree.lastKey();
		MutableInt value = tree.get( element );
		value.decrease();
		if ( value.value == 0 ) {
			tree.remove( element );
		}
		return element;
	}
	
}
