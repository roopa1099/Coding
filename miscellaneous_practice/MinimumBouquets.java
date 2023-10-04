package miscellaneous_practice;

/**
 * Problem Statement:
 * You are given ‘N’ roses and you are also given an array ‘arr’ where ‘arr[i]’
 * denotes that the ‘ith’ rose will bloom on the ‘arr[i]th’ day.
 * You can only pick already bloomed roses that are adjacent to make a bouquet.
 * You are also told that you require exactly ‘k’ adjacent bloomed roses to make
 * a single bouquet.
 * Find the minimum number of days required to make at least ‘m’ bouquets each
 * containing ‘k’ roses. Return -1 if it is not possible.
 */
public class MinimumBouquets {

    private static int minimumInArray(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            minValue = Math.min(minValue, array[i]);
        }
        return minValue;
    }

    private static int maxInArray(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }
        return maxValue;
    }

    private static boolean isBouquetsPossible(int[] array, int flowers, int bouquets, int day) {
        int counter = 0, numberOfBouquets = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= day) {
                counter++;
            } else {
                numberOfBouquets = numberOfBouquets + (counter / flowers);
                counter = 0;
            }
        }
        // for last set when array finished
        numberOfBouquets = numberOfBouquets + (counter / flowers);
        return numberOfBouquets >= bouquets ? true : false;
    }

    public static int minimumDaysForBouquets(int[] array, int bouquets, int flowers) {
        // nLogN
        int day = -1;

        if (array.length < bouquets * flowers) {
            return -1;
        }

        int high = maxInArray(array);
        int low = minimumInArray(array);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isBouquetsPossible(array, flowers, bouquets, mid)) {
                // min required
                day = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return day;
    }

    public static void main(String[] args) {
        int[] array = { 1, 10, 3, 10, 2 };
        System.out.println(minimumDaysForBouquets(array, 3, 2));
    }
}
