package BasicSortingAlgoritms;

import java.util.Random;
import java.util.Arrays;

public class BubbleSort {
	public static final int SIZE = 1000;
	public static final int UPPER_BOUND = 1000;
	
	public static void main( String[] args ) {
		
		double milliseconds = 0;
		int[] nums = new int[SIZE];
		Random rand = new Random();
		
		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
		}
		
		System.out.println("Before Sort:");
		System.out.println(Arrays.toString(nums));
		
		System.out.println("Start Bubble Sort.");
		
		long startTime = System.nanoTime();   // Start timer

		sort(nums);

        long endTime = System.nanoTime();     // End timer
        long elapsedTime = endTime - startTime;

        milliseconds = elapsedTime / 1_000_000.0;
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
			
			try {
				Thread.sleep(0, 500_000);  // .5 milliseconds delay (millisecond, nanosecond)
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
		System.out.printf("Insertion sort of %d elements is complete in %.3f ms%n",
        	    SIZE,
        	    milliseconds);
		
	}
	
	public static void sort(int[] array) {
		for(int i = 0; i < array.length; i++)
			for (int j = 1; j < array.length; j++)
				if(array[j] < array[j - 1]) {
					swap(array, j, j -1);
				}
	}
	
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
