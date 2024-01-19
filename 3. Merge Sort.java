// Java program for Merge Sort
import java.io.*;

class MergeSort {

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		  int n1 = m - l + 1;
      int n2 = r - m;

      // Create temp arrays
      int L[] = new int[n1];
      int R[] = new int[n2];

      // Copy data to temp arrays
      for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
      for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

      // Merge the temp arrays
      // Initial indices of first and second subarrays
      // Initial index of merged subarray array
      int i = 0, j = 0, k = l;
      while (i < n1 && j < n2) 
      {
          if (L[i] <= R[j]) arr[k] = L[i++];
          else arr[k] = R[j++];
          k++;
      }

      // Copy remaining elements of L[] if any
      // Copy remaining elements of R[] if any
      while (i < n1) arr[k++] = L[i++];
      while (j < n2) arr[k++] = R[j++];
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if(l<r)
        {
            int mid = l+(r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
	}

	// A utility function to print array of size n
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given array is");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array is");
		printArray(arr);
	}
}
/* This code is contributed by Rajat Mishra */
