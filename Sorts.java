import java.util.*;
/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
      //System.out.println(Arrays.toString(A));

      int length = A.length;

      boolean swapped = true;

      while(swapped){

        swapped = false;

        for(int pass = 0; pass < length - 1; pass++){

            if(A[pass] > A[pass+1]){

              int temp = A[pass];
              A[pass] = A[pass+1];
              A[pass+1] = temp;

              swapped = true;

            }
          }

          length--;
        }
      
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
      // System.out.println(Arrays.toString(A));

        for(int i = 0; i < A.length - 1; i++){

          int minIdx = i;

          for(int j = i+1; j < A.length; j++){

            if(A[j] < A[minIdx]){

              minIdx = j;
            }
          }

          int temp = A[minIdx];
          A[minIdx] = A[i];
          A[i] = temp;

        }
      
      // System.out.println(Arrays.toString(A));
      // System.out.println("");
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
      // System.out.println(Arrays.toString(A));
      
        for(int nn = 1; nn < A.length ; nn++){

          int ii = nn;

          while (ii > 0 && A[ii-1] > A[ii]){
            int temp = A[ii];
            A[ii] = A[ii-1];
            A[ii-1] = temp;

            ii = ii-1;
          }
        }

      // System.out.println(Arrays.toString(A));
      // System.out.println("");
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
      int lIdx = 0;
      int rIdx = A.length - 1;

      mergeSortRecurse(A, lIdx, rIdx);

    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      if(leftIdx < rightIdx) {
        int midIdx = (leftIdx + rightIdx) / 2;

        mergeSortRecurse(A, leftIdx, midIdx);
        mergeSortRecurse(A, midIdx + 1, rightIdx);

        merge(A, leftIdx, midIdx, rightIdx);
      }         

    }//mergeSortRecurse()

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
      int tempSize = rightIdx - leftIdx +1;
      int[] tempArr = new int[tempSize];

      int ii = leftIdx;
      int jj = midIdx + 1;
      int kk = 0;

      while(ii <= midIdx && jj <= rightIdx) {
        if(A[ii] <= A[jj]){
          tempArr[kk] = A[ii];
          ii++;
        } else {
          tempArr[kk] = A[jj];
          jj++;
        }
        kk++;
      }

      for(int i = ii; i <= midIdx; i++) {
        tempArr[kk] = A[i];
        kk++;
      }
      for(int j = jj; j <= rightIdx; j++) {
        tempArr[kk] = A[j];
        kk++;
      }
      for(int k = leftIdx; k <= rightIdx; k++) {
        A[k] = tempArr[k - leftIdx];
      }

      

    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
      int lIdx = 0;
      int rIdx = A.length - 1;

      quickSortRecurse(A, lIdx, rIdx);

    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      if(rightIdx > leftIdx){
        int pivotIdx = leftIdx; // as mentioned on the assignment
        int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

        quickSortRecurse(A, leftIdx, newPivotIdx - 1);
        quickSortRecurse(A, newPivotIdx + 1, rightIdx);
      }


    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
      int pivotVal = A[pivotIdx];
      A[pivotIdx] = A[rightIdx];
      A[rightIdx] = pivotVal;

      int currIdx = leftIdx;

      for(int i = leftIdx; i <= rightIdx - 1; i++) {
        if(A[i] < pivotVal) {
          int temp = A[i];
          A[i] = A[currIdx];
          A[currIdx] = temp;

          currIdx++;
        }
      }
      
      int newPivotIdx = currIdx;
      A[rightIdx] = A[newPivotIdx];
      A[newPivotIdx] = pivotVal;

      return newPivotIdx;
		// return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning

    public static void quickSortMedian3(int[] A)
    {
      int lIdx = 0;
      int rIdx = A.length - 1;

      quickSortRecurseMed3(A, lIdx, rIdx);

    }//quickSortMedian3()

    private static void quickSortRecurseMed3(int[] A, int leftIdx, int rightIdx)
    {
      if(rightIdx > leftIdx){
        int pivotIdx = (leftIdx + rightIdx) / 2; // median of three
        int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

        quickSortRecurseMed3(A, leftIdx, newPivotIdx - 1);
        quickSortRecurseMed3(A, newPivotIdx + 1, rightIdx);
      }
    }

    public static void quickSortRand(int[] A)
    {
      int lIdx = 0;
      int rIdx = A.length - 1;

      quickSortRecurseRand(A, lIdx, rIdx);

    }//quickSortMedian3()
    private static void quickSortRecurseRand(int[] A, int leftIdx, int rightIdx)
    {
      if(rightIdx > leftIdx){
        Random r = new Random();
        int pivotIdx = r.nextInt((rightIdx - leftIdx) + 1) + leftIdx; // random between left and right index
        //int pivotIdx = (int)(Math.random() * length); // Random
        int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

        quickSortRecurseRand(A, leftIdx, newPivotIdx - 1);
        quickSortRecurseRand(A, newPivotIdx + 1, rightIdx);
      }
    }


}//end Sorts calss
