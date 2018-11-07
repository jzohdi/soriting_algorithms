package sorting_algorithims;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Random;

public class TreeSort {
	
	public static TreeMap<Integer, LinkedList<Integer>> tree = new TreeMap<Integer, LinkedList<Integer>>();
	
	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr  = new int[1000];
		for ( int x = 0; x < 1000; x++ ) {
			int rand = ran.nextInt(900);
			arr[x] = rand;
		}
		
		int[] sorted = treeSort(arr);
		for ( int element : sorted ) {
			System.out.print( element + ", " );
		}	
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
	public static void add( int ele ) {
		if ( tree.containsKey( ele ) ) {
			LinkedList<Integer> list = tree.get( ele );
			list.add( ele );
			tree.put(ele, list);
		}else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add( ele );
			tree.put( ele , list);
		}	
	}
	
	public static int getKey() {
		int element = tree.lastKey();
		LinkedList<Integer> list = tree.get( element );
		int index_ele = list.removeLast();
		if ( list.size() == 0 ) {
			tree.remove( element );
		}
		return index_ele;
	}
	
}
