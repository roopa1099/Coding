package miscellaneous_practice;

/**
 * You are given an array of integers ‘arr’ and an integer i.e. a threshold
 * value ‘limit’. Your task is to find the smallest positive integer divisor,
 * such that upon dividing all the elements of the given array by it, the sum of
 * the division’s result is less than or equal to the given threshold value.
 */
public class SmallestDivisorToReachThresholdSum {
    private static int maxInArray(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }
        return maxValue;
    }

    private static double possibleSum(int[] array, int divisor) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            double div = (double) array[i] / divisor;
            sum = sum + Math.ceil(div);
        }
        return sum;
    }

    public static int smallestDivisor(int[] array, int threshold) {
        // min ceil value after division can be 1, so if dividing by max value of array
        // will give min possible value 1 for all elements which is smallest possible

        int low = 1, high = maxInArray(array), res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            double sum = possibleSum(array, mid);
            if (sum == (double) threshold) {
                res = mid;
                break;
            } else if (sum < (double) threshold) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return res;

    }

    public static void main(String[] args) {
        int[] array = { 8, 4, 2, 3 };
        System.out.println(smallestDivisor(array, 10));
    }

}
