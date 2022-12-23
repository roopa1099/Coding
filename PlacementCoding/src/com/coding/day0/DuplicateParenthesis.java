package com.coding;

import java.util.Stack;

/**
 * Given a balanced expression that can contain opening and closing parenthesis,
 * check if it contains any duplicate parenthesis or not.
 */
public class DuplicateParenthesis {

    public static boolean isDuplicate(String expression){
        char[] array=expression.toCharArray();
        Stack<Character> stack=new Stack<Character>();
        for(char chr:array){
            if(chr==')'){
              if(stack.peek()=='(')
                  return true;
              else{
                  while(stack.peek()!='('){
                      stack.pop();
                  }
                  stack.pop();
              }
            }
            else{
              stack.push(chr);
            }
        }
        return false;
    }

    public static void main(String[] args){
        String expression="((x+y))+z";
        System.out.println(isDuplicate(expression));
    }
}
