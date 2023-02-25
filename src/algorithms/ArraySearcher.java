public class ArraySearcher {
    public static int binarySearch(int[] array, int item) {
        int start = 0;
        int end = array.length;
        int index = -1;

        while (start != end ) {
            int mid = start + (end - start)/2;
            if (arr[mid] == item) {
                index = mid;
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        return index;
    }
}