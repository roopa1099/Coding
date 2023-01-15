package com.coding.recursion;

import java.util.Stack;

/**
 * Reverse stack using recursion
 */
public class RecReverseStack {

    static Stack<Character> stc = new Stack<>();
        public static void insertAtBottom(char val){

        if(stc.empty()){
            stc.push(val);
        }
        else{
        char top=(char) stc.peek();
        stc.pop();
        insertAtBottom(val);
        stc.push(top);
        }

    }


    public static void reverse() {
        char element;
        if(stc.size()>0){
        element=(char) stc.peek();
        stc.pop();
        reverse();
        insertAtBottom(element);
        }        
    }

    public static void main(String[] args) {
        stc.push('2');
        stc.push('3');
        stc.push('4');
        stc.push('5');
        stc.push('6');
        stc.push('7');
        reverse();
        System.out.println(stc);
    }
}
