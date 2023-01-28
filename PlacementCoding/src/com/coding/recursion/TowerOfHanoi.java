package com.coding.recursion;

/**
 *  O(2n)
 * The Tower of Hanoi is a mathematical puzzle consisting of three rods and n disks of 
 * different sizes which can slide onto any rod.

 
The puzzle starts with the disks in a neat stack in ascending order of size on one rod, 
the smallest at the top, making a conical shape. The objective of the puzzle is to move 
the entire stack to another rod, obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack, i.e., a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk.
 */
public class TowerOfHanoi {
    
    public static void hanoi(int discs, int source,int target, int aux) {
        
        if(discs>0){
            // n-1 dics to aux
            hanoi(discs-1,source,aux,target);

            // Move n from src to target
            System.out.println("Move disc "+discs+" from "+source+" to "+ target);

            hanoi(discs-1, aux, target, source);
        }
              
    }
    public static void main(String[] args) {
        hanoi(5, 1, 3, 2);
    }
}
