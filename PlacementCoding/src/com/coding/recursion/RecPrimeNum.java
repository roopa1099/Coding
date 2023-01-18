package com.coding.recursion;

/**
 * Check if prime number
 */
public class RecPrimeNum {
    
    public static boolean isPrime(int number, int factor) {

        

        if(factor*2>number){
            return true;
        }

        boolean ifPrime=isPrime(number, factor+1);
        if(!ifPrime){
            return ifPrime;
        }
        else{
            if(number%factor==0){
                return false;
            }
            return true;
        }
        
    }

    public static boolean checkPrime(int number) {
        if(number==1 || number==0){
            return false;
        }
        return isPrime(number, 2);
        
    }

    public static void main(String[] args) {
        int number=12;
        System.out.println(checkPrime(number));
    }
}
