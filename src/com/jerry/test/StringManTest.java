package com.jerry.test;

import com.jerry.stringman.StringMan;

import java.util.Arrays;
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

        System.out.println("Delete: " + StringMan.deleteString("a1bcb2db", "b"));

        System.out.println("Surround all: " + new StringMan("V1s23A123B123C").surroundAll("123", "[", "]"));

        System.out.println("Detach surround: " + new StringMan("<html->>").detachSurround("<", ">"));

        System.out.println("Detach all surroundings: " + new StringMan("[123][456][7[00000]89]").detachAllSurrounds("[", "]"));

        long a = System.currentTimeMillis();
        System.out.println("Get complementary 1: " + StringMan.getComplementary(StringMan.getRandomString(1000000), "A") + "\n Consumes: " + (System.currentTimeMillis() - a) + "ms");

        System.out.println("To String Array:\n" + "Origin string: " + "Hello there.\n" + "String array: " + Arrays.toString(StringMan.toStringArray("Hello there.")));

        System.out.println("Does [1, 2, 3, 4, 2, 1] have same numbers?\n" + StringMan.intArrayHasSameNumbers(new int[]{1, 2, 3, 4, 2, 1}));

        System.out.println("Does [1, 2, 3, 4, 5, 0] have same numbers?\n" + StringMan.intArrayHasSameNumbers(new int[]{1, 2, 3, 4, 5, 0}));

        System.out.println("Does [1, 1, 1, 1, 1, 1] have different numbers?\n" + StringMan.intArrayHasDifferentNumbers(new int[]{1, 1, 1, 1, 1, 1}));

        System.out.println("Does [1, 2, 3, 4, 5, 0] have different numbers?\n" + StringMan.intArrayHasDifferentNumbers(new int[]{1, 2, 3, 4, 5, 0}));

        System.out.println("Trim int[]: [1, 1, 2, 4, 5, 1] -> " + Arrays.toString(new StringMan().trimIntArray(new int[]{1, 1, 2, 4, 5, 1})));

        System.out.println("Random index array(len = 10): " + Arrays.toString(new StringMan(StringMan.getRandomString(100)).randomIndex()));

        System.out.println("Shuffle: panda -> " + StringMan.shuffle("panda"));

        System.out.println(StringMan.getConsecutive("=", 150));

    }
}
