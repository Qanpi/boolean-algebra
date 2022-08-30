package com.company;

public class Main {

    public static void main(String[] args) {
    }

    public static boolean hw1(boolean weekday, boolean vacation) {
        if (weekday && vacation) return true;
        return false;
    }

    public static boolean hw2(boolean shining, int time) {
        if (shining && (time > 10 && time < 16)) return true;
        return false;
    }

    public static boolean hw3(int A, int B){
        String a = Integer.toString(A);
        String b = Integer.toString(B);
        if (a.charAt(a.length() - 1) == b.charAt(b.length()-1))
            return true;
        return false;
    }

    public static void hw4() {
        int i = 1;
        while (!(i % 387 == 0 && i % 6381 == 0)) {
            i++;
        }
        System.out.println(i);
    }

    public static void hw41() {
        int i = 387;
        while (i % 6381 != 0){
            i+=387;
        }
        System.out.println(i);
    }

    public static boolean hw6(int a) {
        if (a<=1) return false;
        for (int i=2; i<Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static boolean hw7(boolean A, boolean B) {
        return !(A ^ B); //or just A == B
    }
}
