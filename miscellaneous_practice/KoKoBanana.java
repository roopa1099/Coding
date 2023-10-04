package miscellaneous_practice;

/**
 * Given an sorted array, containing bunch of bananas that KoKo can eat.
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * Example 1:
 * 
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * 
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * 
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 */
public class KoKoBanana {

    /**
     * Minimum banana i should eat from the array to complete in minimum hours is
     * the max value in array
     * [3,5,7,9,10] At a time i can eat from a pile, so I need atleat 5 hours if I
     * eat 10 bananas per hour, If i eat more than that
     * still it will take atleast 5 hours
     * 
     * @param array
     * @return
     */
    public static int bananaPerHour(int[] array, int timeLimit) {
        int low = 1, high = array[array.length - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            double timeTaken = hoursToEatBanana(array, mid);
            if (timeTaken == (double) timeLimit) {
                return mid;
            } else if (timeTaken < timeLimit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static double hoursToEatBanana(int[] array, int minBanana) {
        int i = 0;
        double hours = 0;
        while (i < array.length) {
            double tempHour = Math.ceil((double) array[i] / (double) minBanana);
            hours = hours + tempHour;
            i++;
        }
        return hours;
    }

    public static void main(String[] args) {
        int[] array = { 3, 6, 7, 11 };
        System.out.println(bananaPerHour(array, 8));
    }
}
