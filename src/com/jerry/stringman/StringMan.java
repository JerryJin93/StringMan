package com.jerry.stringman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringMan {

    private String stringMan;

    public int[] pattern;

    private static final char[] DICTIONARY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public StringMan(){
        super();
    }

    public StringMan(String stringMan) {
        this.stringMan = stringMan;
    }

    public StringMan(byte[] bytes){
        stringMan = new String(bytes);
    }

    public StringMan(StringBuffer buffer) {
        stringMan = new String(buffer);
    }

    public StringMan(StringBuilder builder) {
        stringMan = new String(builder);
    }

    public String getStringMan() {
        return stringMan;
    }

    public void setStringMan(String stringMan) {
        this.stringMan = stringMan;
    }

    public char charAt(int index){
        return stringMan.charAt(index);
    }

    public static char charAt(String string, int index) {
        return string.charAt(index);
    }

    //OK
    /**
     * Get all indexes of the specific string.
     * @param str The string which you want to look up for all its indexes.
     * @return An array of all indexes.
     * @throws NullPointerException Throws exception when this.stringMan is null.
     */
    public int[] allIndexesOf(String str) throws NullPointerException {
        List<Integer> indexesList = new ArrayList<>();
        int index = stringMan.indexOf(str);
        while (index != -1) {
            indexesList.add(index);
            index = stringMan.indexOf(str, index + 1);
        }
        int[] indexes = new int[indexesList.size()];
        for (int i = 0; i < indexes.length; i++){
            indexes[i] = indexesList.get(i);
        }
        return indexes;
    }
    //OK
    public static int[] getAllIndexes(String origin, String str) {
        return new StringMan(origin).allIndexesOf(str);
    }

    /**
     * Generate a string by picking random character from the dictionary.
     * @param length The length of the string to generate.
     * @return Generated string.
     */
    public static String getRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            builder.append(DICTIONARY[random.nextInt(DICTIONARY.length)]);
        }
        return builder.toString();
    }

    public StringMan append(String str){
        if (stringMan != null){
            setStringMan(new StringBuilder(stringMan).append(str).toString());
        }
        else {
            setStringMan(str);
        }
        return this;
    }

    public StringMan append(boolean b){
        this.append(String.valueOf(b));
        return this;
    }

    public StringMan append(char c){
        this.append(String.valueOf(c));
        return this;
    }

    public StringMan append(int i){
        this.append(String.valueOf(i));
        return this;
    }

    public StringMan append(float f){
        this.append(String.valueOf(f));
        return this;
    }

    public StringMan append(double d){
        this.append(String.valueOf(d));
        return this;
    }

    public StringMan append(StringMan stringMan){
        this.append(stringMan.toString());
        return this;
    }

//    public abstract StringMan append(Object o);

    public static String appendArray(String... strings){
        StringBuilder builder = new StringBuilder();
        for (String str : strings){
            builder.append(str);
        }
        return builder.toString();
    }

    public StringMan append(String[] strings){
        String str = stringOf(strings);
        this.append(str);
        return this;
    }

    public StringMan appendMultiple(String... strings){
        String str = stringOf(strings);
        this.append(str);
        return this;
    }

    public static String append(String original, String[] strings){
        return original + new StringMan().stringOf(strings);
    }

    public StringMan insert(int offset, String str){
        if (stringMan != null){
            setStringMan(new StringBuilder(stringMan).insert(offset, str).toString());
        }
        else {
            setStringMan(str);
        }
        return this;
    }

    public StringMan insertArray(int offset, String[] strings){
        String str = stringOf(strings);
        this.insert(offset, str);
        return this;
    }

    public String stringOf(String[] strings){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++){
            builder.append(strings[i]);
        }
        return builder.toString();
    }

    public StringMan deleteString(String toDelete){
        try{
            StringBuilder builder = new StringBuilder(stringMan);
            int[] indexes = allIndexesOf(toDelete);
            for (int i = 0; i < indexes.length; i++){
                builder.delete(indexes[i], indexes[i] + toDelete.length());
                if (i + 1 < indexes.length){
                    indexes[i + 1] -= toDelete.length() * (i + 1);
                }
            }
            setStringMan(builder.toString());
        } catch (NullPointerException e){
            //e.printStackTrace();
        }
        return this;
    }

    public static StringMan deleteString(String origin, String toDelete) {
        return new StringMan(origin).deleteString(toDelete);
    }

    public StringMan delete(int start, int end){
        if (stringMan != null){
            StringBuilder builder = new StringBuilder(stringMan);
            builder.delete(start, end);
            setStringMan(builder.toString());
        }
        return this;
    }

    public static String delete(String origin, int start, int end){
        return new StringMan(origin).delete(start, end).toString();
    }

    public int length(){
        return stringMan.length();
    }

    /**
     * Reverse the string field of a StringMan.
     * @return Reversed StringMan.
     */
    public StringMan reverse(){
        if (stringMan != null){
            setStringMan(new StringBuilder(stringMan).reverse().toString());
        }
        return this;
    }

    public static String reverse(String stringMan){
        return new StringBuilder(stringMan).reverse().toString();
    }

//    public static String toCamelCase(String origin){
//
//    }

    /**
     *
     * @param start Inclusive.
     * @param end Exclusive.
     * @return
     */
    public StringMan subString(int start, int end){
        if (stringMan != null){
            setStringMan(stringMan.substring(start, end));
        }
        return this;
    }

    /**
     *
     * @param prefix The prefix string you want to insert.
     * @param suffix The suffix string you want to insert.
     * @return Current StringMan object that has been processed.
     */
    public StringMan surround(String prefix, String suffix){
        if (stringMan != null){
            setStringMan(new StringBuilder(stringMan).insert(0, prefix).append(suffix).toString());
        }
        else {
            setStringMan(prefix + suffix);
        }
        return this;
    }

    /**
     * Surround a string with prefix and suffix.
     * @param origin The origin string you want to process.
     * @param prefix The prefix string you want to insert.
     * @param suffix The suffix string you want to insert.
     * @return Processed string.
     */
    public static String surround(String origin, String prefix, String suffix){
        return new StringMan(origin).surround(prefix, suffix).toString();
    }

    public StringMan surroundAll(String strToSurround, String prefix, String suffix){
        if (stringMan != null){
            int[] indexes = allIndexesOf(strToSurround);
            StringBuilder builder = new StringBuilder(stringMan);
            for (int i = 0; i < indexes.length; i++){
                builder.insert(indexes[i], prefix);
                indexes[i] += prefix.length();
                builder.insert(indexes[i] + strToSurround.length(), suffix);
                indexes = getAllIndexes(builder.toString(), strToSurround);
            }
            setStringMan(builder.toString());
        }
        else {
            setStringMan(prefix + suffix);
        }
        return this;
    }

    public static String surroundAll(String origin, String strToSurround, String prefix, String suffix){
        return new StringMan(origin).surroundAll(strToSurround, prefix, suffix).toString();
    }

    public StringMan detachSurround(String prefix, String suffix){
        if (stringMan != null){
            if (stringMan.contains(prefix)){
                delete(0, prefix.length());
            }
            if (stringMan.contains(suffix)){
                int indexOfSuffix = stringMan.indexOf(suffix);
                delete(indexOfSuffix, indexOfSuffix + suffix.length());
            }
        }
        return this;
    }

    public static String detachSurround(String origin, String prefix, String suffix){
        return new StringMan(origin).detachSurround(prefix, suffix).toString();
    }

    public StringMan detachAllSurroundings(String prefix, String suffix){
        if (stringMan != null){
            int[] indexesPrefix = allIndexesOf(prefix);
            int[] indexesSuffix = allIndexesOf(suffix);
            StringBuilder builder = new StringBuilder(stringMan);
            if (indexesPrefix.length != 0){
                for (int i = 0; i < indexesPrefix.length; i++){
                    builder.delete(indexesPrefix[i], indexesPrefix[i] + prefix.length());
                    if (i + 1 < indexesPrefix.length){
                        indexesPrefix[i + 1] -= prefix.length() * (i + 1);
                    }
                }
                setStringMan(builder.toString());
            }
            if (indexesSuffix.length != 0){
                indexesSuffix = getAllIndexes(builder.toString(), suffix);
                for (int i = 0; i < indexesSuffix.length; i++){
                    builder.delete(indexesSuffix[i], indexesSuffix[i] + suffix.length());
                    if(i + 1 < indexesSuffix.length){
                        indexesSuffix[i + 1] -= suffix.length() * (i + 1);
                    }
                }
                setStringMan(builder.toString());
            }
        }
        return this;
    }

    public static String detachAllSurroundings(String origin, String prefix, String suffix){
        return new StringMan(origin).detachAllSurroundings(prefix, suffix).toString();
    }

//    public String encode(){
//        Random random = new Random();
//        pattern = new int[random.nextInt(stringMan.length())];
//        for (int i = 0; i < pattern.length; i++){
//            pattern[i] = random.nextInt(stringMan.length());
//            insert(pattern[i], getRandomString(pattern[i]));
//        }
//        return stringMan;
//    }

    public static String getConsecutive(String str, int num){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++){
            builder.append(str);
        }
        return builder.toString();
    }

    public static String getStars(int num){
        return getConsecutive("*", num);
    }

    public static String getDashes(int num){
        return getConsecutive("-", num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            if (o.getClass() == String.class){
                return stringMan.equals(o);
            }
            else {
                return false;
            }
        }
        else {
            return stringMan.equals(o.toString());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return stringMan;
    }
}
