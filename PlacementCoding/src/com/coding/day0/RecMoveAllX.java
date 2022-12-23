package com.coding;

public class RecMoveAllX {

    public static void moveAllX(String str,int index, int count, StringBuilder newStr){

        if(index==str.length()){
            while(count>0){
                newStr=newStr.append("a");
                count--;
            }
            System.out.println(newStr);
            return;
        }
        if(str.charAt(index)=='a'){
            count++;
        }
        else{
            newStr=newStr.append(str.charAt(index));
        }
        moveAllX(str,index+1,count,newStr);
    }
    public static void main(String[] args){
        StringBuilder strBuild=new StringBuilder();
        moveAllX("cbaahfacgatrd",0,0,strBuild);
    }
}
