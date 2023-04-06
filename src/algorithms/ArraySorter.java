package algorithms;

public class ArraySorter {
    public static void insertionSort(int[] array) {
        //Insertion Sort Procedure
        //1. Divide the array into a sorted part and an unsorted part
        //2. Iterate over the array elements
        //3. Consider each iterated element as the newest entry to be inserted into the sorted part
        //   Also note that newest entry is located at the end of the sorted array
        //   Move the newest entry to its rightful place by compare and swapping with each element of the sorted array starting from the end
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int smallerValue = array[j];
                    array[j] = array[j-1];
                    array[j-1] = smallerValue;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        //Selection Sort Procedure
        //1. Scan the list and swap the minimum element with the first element (Minimum element is now sorted)
        //2. Scan the list and swap the next minimum element with the second element
        //3. Continue until the array is sorted
        for (int i = 0; i < array.length; i++) {
            int smallestValueIndex = 0;
            int smallestValueOfRange = Integer.MAX_VALUE;
            for (int j = i; j < array.length; j++) {
                if (array[j] < smallestValueOfRange) {
                    smallestValueOfRange = array[j];
                    smallestValueIndex = j;
                }
            }
            array[smallestValueIndex] = array[i];
            array[i] = smallestValueOfRange;
        }
    }

    public static void bubbleSort(int[] array) {
        //Bubble Sort Procedure
        //1. Compare each adjacent pairs of elements and promote smallest of each pair by a swap (eg. Indices 0and1, 1and2, 2and3 .......)
        //2. After the first round, check if there were any swaps. If yes repeat the above. Else the array is sorted
        boolean swapsOccurred = true;

        while (swapsOccurred) {
            swapsOccurred = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    int smallerValue = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = smallerValue;
                    swapsOccurred = true;
                }
            }
        }
    }

    public static void quicksort(int[] array, int startIndex, int endIndex) {
        //Quick Sort Procedure (Divide And Conquer)
        //1. Consider the last element of each list as the pivot
        //2. Traverse the array sequentially and check if each element is less than pivot. If yes swap it with element in "minimumSwappableIndex"
        //The "minimumSwappableIndex" starts at "startIndex - 1" for each list and increments by +1 for each swap
        
        if (startIndex != endIndex && startIndex < endIndex) {
            int minimumSwappableIndex = startIndex - 1;
            for (int i = startIndex; i <= endIndex; i++) {
                if (array[i] <= array[endIndex]) {
                    minimumSwappableIndex++;
                    int currentValue = array[i];
                    array[i] = array[minimumSwappableIndex];
                    array[minimumSwappableIndex] = currentValue;
                }
            }
            quicksort(array, startIndex, minimumSwappableIndex - 1);
            quicksort(array, minimumSwappableIndex + 1, endIndex);
        }
    }

    public static void mergeSort() {
        //Merge Sort Procedure (Divide And Conquer)
    }
}