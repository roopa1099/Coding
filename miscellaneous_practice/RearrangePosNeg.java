
import java.util.ArrayList;
import java.util.List;

public class RearrangePosNeg {

    /**
     * Equal Pos Neg
     */
    public static int[] reaarange(int[] array) {
        // t(n)=O(n), space=O(n);
        int[] result = new int[array.length];
        int pos = 0, neg = 1, pt = 0;
        while (pt < array.length) {
            if (array[pt] > 0) {
                result[pos] = array[pt];
                pos = pos + 2;
            } else {
                result[neg] = array[pt];
                neg = neg + 2;
            }
            pt++;
        }
        return result;
    }

    /**
     * Unequal pos and neg
     * 
     * @param array
     * @return
     */
    public static int[] rearrange(int[] array) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                pos.add(array[i]);
            } else {
                neg.add(array[i]);
            }
        }
        int posPt = 0, negPt = 0, p = 0;
        while (p < array.length) {
            if (p % 2 == 0) {
                array[p] = pos.get(posPt);
                posPt++;
            } else {
                array[p] = neg.get(negPt);
                negPt++;
            }
            ;
            p++;
        }

        while (posPt < pos.size()) {
            array[p] = pos.get(posPt);
            p++;
            posPt++;
        }

        while (negPt < neg.size()) {
            array[p] = neg.get(negPt);
            p++;
            negPt++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, -5, 2, -6, -7 };
        int[] rres = rearrange(arr);
        for (int i : rres)
            System.out.println(i);
    }
}
