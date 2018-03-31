package com.jerry.test;

import com.jerry.stringman.StringMan;

import java.util.Objects;

public class StringManTest {

    public static void main(String[] args){

        final String[] greeting = {"Hey", " how are you?"};
        StringMan stringMan = new StringMan();

        System.out.println("Starting test...");

        System.out.println(StringMan.getConsecutive("=", 150));

        System.out.println("Get random string(len = 10): " + StringMan.getRandomString(10));

        System.out.println("\nAppending test:");

        System.out.println("Origin string: " + stringMan);

        System.out.println("New string: " + stringMan.append("Hey, ").append(new String[]{"I", " like", " watching"}).appendMultiple(" movies", " and traveling"));

        System.out.println("And its length: " + stringMan.length());

        System.out.println("Then reverse object stringMan: " + StringMan.reverse(stringMan.toString()) + ", HashCode: " + Objects.hashCode(stringMan));

        System.out.println("After reversing by using static method: stringMan = " + stringMan + ", HashCode: " + Objects.hashCode(stringMan));


        System.out.println("After reversing by using object method: stringMan = " + stringMan.reverse() + ", HashCode: " + Objects.hashCode(stringMan));



        System.out.println(StringMan.getConsecutive("=", 150));

    }
}
