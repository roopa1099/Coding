public class PeakElement {

    public static int findPeakElement(int[] array, int start, int end) {

        if (array.length == 1) {
            return array[0];
        }

        int peakElement = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // for all mid elements
            if (mid > 0 && mid < array.length - 1) {
                if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                    return array[mid];
                } else if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1]) {
                    // increasing
                    start = mid + 1;
                } else {
                    // decreasin
                    end = mid - 1;
                }

            } else if (mid == 0 && array[mid] > array[mid + 1]) {
                // first element
                return array[mid];
            } else if (mid == array.length - 1 && array[mid] > array[mid - 1]) {
                // last element
                return array[mid];
            }
        }
        return peakElement;
    }

    public static void main(String[] args) {
        int[] array = { 2, 15, 16, 4, };
        System.out.println(findPeakElement(array, 0, array.length - 1));

    }
}
