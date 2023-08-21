package miscellaneous_practice;
/**
 * Remove duplicate in place from a sorted array
 */
public class RemoveDuplicate{

    public static int[] removeDuplicate(int[] array) {
        //brute force will be use a set to store as it doesnot store duplicate, then add it back to array

        //optimal O(N)
        int pointer2=1,pointer1=0;
        while(pointer2<array.length){
            if(array[pointer1]!=array[pointer2]){
                array[pointer1+1]=array[pointer2];
                pointer1++;
            }
          
            pointer2++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array={2,3,3,6,7,7,9};
        array=removeDuplicate(array);
        for(int i=0;i<array.length;i++){
         System.out.println(array[i]);
        }
  
    }
}