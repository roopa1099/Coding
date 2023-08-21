package miscellaneous_practice;

/**
 * Left rotate elements in array by d times
 */
public class LeftRotate {

    private static void reverseArray(int[] array,int start, int end) {
        while(start<end){
            int temp=array[end];
            array[end]=array[start];
            array[start]=temp;
            start++;
            end--;
        }
    }
    public static void leftRotate(int[] array, int rotateBy) {
        rotateBy=rotateBy%array.length;
        // Bruteforce: save first rotateBy element in a array, then move n-rotateBy to n by 1 place, then add the
        //   first rotateBy element  from n-rotateBy to n O(N-rotateBy); space:O(rotateBy)

        // optimal: t(n): O(N), space: O(1);
        reverseArray(array, 0, array.length-1);
        reverseArray(array, 0, array.length-rotateBy-1);
        reverseArray(array, array.length-rotateBy, array.length-1);
    }
    public static void main(String[] args) {
        int[] array={34,12,65,36,75};
        leftRotate(array, 6);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
           }
    }
}
