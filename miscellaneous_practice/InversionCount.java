package miscellaneous_practice;

/**
 * Given an array of N integers, count the inversion of the array
 */
public class InversionCount {

    private static int mergeArray(int[] array, int start, int mid, int end) {
        int count = 0;

        int start1 = start, start2 = mid + 1, pt = 0;
        int[] temp = new int[end - start + 1];
        while (start1 <= mid && start2 <= end) {
            if (array[start1] < array[start2]) {
                temp[pt] = array[start1];
                start1++;
            } else {
          
                temp[pt] = array[start2];
                // all elements right to start1 wll also be greater than lement at start 2
                count = count + (mid - start1 + 1);
                start2++;
            }
            pt++;
        }

        while (start1 <= mid) {
            temp[pt] = array[start1];
            start1++;
            pt++;
        }

        while (start2 <= end) {
            temp[pt] = array[start2];
            start2++;
            pt++;
        }

        pt = 0;
        for (int i = start; i <= end; i++) {
            array[i] = temp[pt];
            pt++;
        }
        return count;
    }

    public static int sortArray(int[] array, int start, int end) {
        // t(n)=nLog(n), space=O(n);
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            // divide
            // prev count
            count = count + sortArray(array, start, mid);
            count = count + sortArray(array, mid + 1, end);
            // merge ny sorting
            // current count
            count = count + mergeArray(array, start, mid, end);
        }
        return count;

    }

    public static void main(String[] args) {
        int[] array = { 4, 5, 2, 1, 6, 7, 4 };
        System.out.println(sortArray(array, 0, array.length - 1));
    }
}
