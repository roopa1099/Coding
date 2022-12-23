package com.coding;

/**
 * Function to replcase all " " with "i%20"
 */
public class ReplaceSpaceWithChar {
    public static String replace(String str) {
        String res = new String("");
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                res = res + "%20";
            } else {
                res = res + ch;
            }
        }
        return res;
    }

        public static String replaceTwo(String str){
            String res=new String("");
            for(char ch:str.toCharArray()){
                if(ch==' '){
                    res=res+"%20";
                }
                else{
                    res = res+ch;
                }
            }

       return res;
    }
    public static void main(String[] args){
        System.out.println(replace("I liked the movie, acting in movie was great!"));
    }

}
