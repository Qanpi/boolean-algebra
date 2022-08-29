package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(hw3(347367, 1820));
    }
    public static boolean hw3(int A, int B){
        String a = Integer.toString(A);
        String b = Integer.toString(B);
        if (a.charAt(a.length() - 1) == b.charAt(b.length()-1))
            return true;
        return false;
    }
}
