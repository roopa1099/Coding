package com.coding;

/**
 * in string if u keep adding new val like str+"ab" in JAVA, everytime, new string is created and creation
 * takes more time, in string builder, existing string is updated by appendin, taking less time.
 */
public class StringBuilderTest {

    public static void main(String[] args){
        StringBuilder sbt=new StringBuilder("hello");
        sbt.append("Append");
        System.out.println(sbt);
        sbt.insert(2,"insert");
        System.out.println(sbt);
        sbt.setCharAt(3,'b');
        System.out.println(sbt);
        sbt.delete(4,7);
        System.out.println(sbt);

    }
}

