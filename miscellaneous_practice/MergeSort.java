package miscellaneous_practice;

public class MergeSort {

    private static void mergeArray(int[] array, int start, int mid, int end) {

        int start1 = start, start2 = mid + 1, pt = 0;
        int[] temp = new int[end - start + 1];
        while (start1 <= mid && start2 <= end) {
            if (array[start1] < array[start2]) {
                temp[pt] = array[start1];
                start1++;
            } else {
                temp[pt] = array[start2];
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
    }

    public static void sortArray(int[] array, int start, int end) {
        // t(n)=nLog(n), space=O(n);
        if (start < end) {
            int mid = (start + end) / 2;
            // divide
            sortArray(array, start, mid);
            sortArray(array, mid + 1, end);
            // merge ny sorting
            mergeArray(array, start, mid, end);
        } else {
            return;
        }

    }

    public static void main(String[] args) {
        int[] array = { 4, 1, 6, 2, 8, 9 };
        sortArray(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
