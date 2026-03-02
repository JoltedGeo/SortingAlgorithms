package BasicSortingAlgoritms;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
	public static final int SIZE = 1000;
	public static final int UPPER_BOUND = 1000;

	public static void main(String[] args) {
		
		double milliseconds = 0;
		int[] nums = new int[SIZE];
		Random rand = new Random();
		
		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
		}
		
		System.out.println("Before Sort:");
		System.out.println(Arrays.toString(nums));
		
		// Start timer
		long startTime = System.nanoTime();
		
		selectionSort(nums);
		
		// End timer
		long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Set the elapsed time to milliseconds
        milliseconds = elapsedTime / 1_000_000.0;
		
        // Print out the sorted array one index at a time for visual sake with a delay
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
			
			// Add delay
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
	
	private static void selectionSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			
			// Makes the lowest array element minIndex
			int minIndex = i;
			
			// Loops through the following array to the right to find next lowest index
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[minIndex]) {
					// Set next lowest value to minIndex 
					minIndex = j;
				}
			}
			
			// Swap the lowest index (which is already i) to the minimum index found within the array to the right of i
			if (minIndex != i)
				swap(array, i, minIndex);
			
		}
	}
	
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
