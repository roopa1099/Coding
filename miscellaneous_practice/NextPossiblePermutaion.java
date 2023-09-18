package miscellaneous_practice;

/**
 *  Find next possible permutation of the array.
 * 
 * Bruteforce : Find all possible permutation, check where the given permutation lies, then return next
 */
public class NextPossiblePermutaion {
    private static void reverse(int[] array, int start, int end){
        //t(n)=O(3n)
        while(start<end){
            int temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }

    }
    public static void nextPermutation(int [] array) {
        // Find first index from right where arra[i]<array[i+1];
        int index=-1;
        for(int i=array.length-2;i>=0;i--){
            if(array[i]<array[i+1]){
                index=i;
                break;
            }
        }

        // find left most element just greater than element in the "index"
        if(index==-1){
            reverse(array,0,array.length-1);
        }
        else{
            int left=array.length-1;
            while(left>index){
                if(array[left]>array[index]){
                    //swap
                        int temp=array[index];
                        array[index]=array[left];
                        array[left]=temp;
                        break;
                }
                left--;
            }
            // reverse rest element
            reverse(array, index+1,array.length-1);
        }        
    }
    
    public static void main(String[] args) {
        int[] array={7,6,2,5,4,0,0};
        nextPermutation(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
