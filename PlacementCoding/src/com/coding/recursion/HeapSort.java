package com.coding.recursion;

/**
 * **********IMPORTANT******************
 * 
 * Heap Sort
 */
public class HeapSort {
    
    public static void sort(int[] array) {
        int length=array.length;

        /**
         * From N/2 to N elements, they are leaf nodes, that is no child(for index staring form 1)
         */
        for(int i=(length/2)-1;i>=0;i--){
            heapify(array, length, i);
        }
// after heapify, move 1 element to last as it will be largest in max heap.
// Then move last s first element and then heapify to adjust it;
        for(int i=length-1;i>=0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int length, int iNode) {

        int largest=iNode;

        int leftNode=2*iNode+1;
        int rightNode=2*iNode+2;

        // check if lft or right child is larger
        if(leftNode<length && array[leftNode]>array[iNode]){
            largest=leftNode;
        }

        if(rightNode<length && array[rightNode]>array[largest]){
            largest=rightNode;
        }


        if(largest!=iNode){
            // swap with largest
            int swap=array[largest];
            array[largest]=array[iNode];
            array[iNode]=swap;
            // heapify child according to it
            heapify(array, length, largest);
        }
        
        // Heapify rest of the children connected to right or left child
        
    }

    public static void main(String[] args) {
        int[] array={4,2,7,5,9,1,5};
        sort(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
