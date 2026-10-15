
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
      int rIdx;
      rIdx = A.length - 1;

      mergeSortRecurse(A, lIdx, rIdx);

    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      if(leftIdx < rightIdx) {
        int midIdx = (leftIdx + rightIdx) / 2;

        mergeSortRecurse(A, leftIdx, midIdx);
        mergeSortRecurse(A, midIdx + 1, rightIdx);

        merge(A, leftIdx, midIdx, rightIdx);
      } else 
        System.out.println("Array is already sorted!");

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
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
