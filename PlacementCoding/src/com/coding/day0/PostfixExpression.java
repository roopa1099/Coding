package com.coding.day0;

import java.util.Stack;

/**
 * Write code to evaluate a given postfix expression efficiently.
 */
public class PostfixExpression {

    public static int operationValue(int a,int b,String operator){
        if(operator.equals("*"))
            return a*b;
        else if(operator.equals("/"))
            return a/b;
        else if(operator.equals("+"))
            return a+b;
        else
            return a-b;
    }

    public static int postfixExpression(String experession){
        Stack<Integer> stack = new Stack<Integer>();
            for(char chr:experession.toCharArray()){
                if(chr>='0' && chr<='9'){
                    stack.push(Integer.parseInt(String.valueOf(chr)));
                }
                else{
                    int b=stack.pop();
                    int a=stack.pop();
                    int value=operationValue(a,b,String.valueOf(chr));
                    stack.push(value);
                }
            }

            return stack.pop();
    }

    public static void main(String[] args){
        String expression="545*+5/";
        System.out.println(postfixExpression(expression));
    }
}
