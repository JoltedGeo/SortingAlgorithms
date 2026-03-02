package BasicSortingAlgoritms;

import java.util.Arrays;
import java.util.Random;

public class DecendingInsertionSort
{
	public static final int SIZE = 10000;
	public static final int UPPER_BOUND = 1000;

	public static void main( String[] args )
	{
		double milliseconds = 0;
		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();

		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
			System.out.println( nums[i] );
		}
		
		//Print array before sorting
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(nums));
        
        long startTime = System.nanoTime();   // Start timer

        insertionSort(nums);

        long endTime = System.nanoTime();     // End timer
        long elapsedTime = endTime - startTime;
        milliseconds = elapsedTime / 1_000_000.0;
        
        // Print array after sorting
        // System.out.println("After sorting:");
        // System.out.println(Arrays.toString(nums));
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
	
	
	// (i) This is the insertion sorting algorithm in DESCENDING order
	// j is for the elements, key is the data inside the array that's being moved
	public static void insertionSort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Shift elements smaller than key to the right. Swap < to > for ACCENDING order
            while (j >= 0 && array[j] < key) {
            	// Move element to the right
                array[j + 1] = array[j];
                j--;
            }

            // Insert key in correct position
            array[j + 1] = key;
        }
	}
}
