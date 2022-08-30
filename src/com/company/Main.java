package com.company;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            long a = 101;
            count_time(a, false);
            count_time(a, true);

            a = Integer.MAX_VALUE;
            count_time(a, false);
            count_time(a, true);

            a = Long.MAX_VALUE;
            count_time(a, false);
            count_time(a, true);

        } catch (IOException e) {
            System.err.println("Something went terribly wrong...");
        }
    }

    public static void count_time(long a, boolean api) throws IOException {
        long start = System.currentTimeMillis();
        boolean isPrime = api ? hw61(a) : hw6(a);
        long end = System.currentTimeMillis();

        String func = api ? "API" : "normal";
        System.out.printf("It took %d milliseconds for the %s prime function to determine if %d is prime: %b \n", end-start, func, a, isPrime);
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

    public static boolean hw6(long a) {
        if (a<=1) return false;
        for (long i=2; i<Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static boolean hw61(long a) throws IOException {
        final String url = "http://compoasso.free.fr/primelistweb/page/prime/liste_online_en.php";
        final String query = "numberInput=" + a;

        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        try (OutputStream output = connection.getOutputStream()) {
            output.write(query.getBytes(StandardCharsets.UTF_8));
        }

        InputStream response = connection.getInputStream();
        // int status = ((HttpURLConnection) connection).getResponseCode();

        try (Scanner sc = new Scanner(response)) {
            String pat = "<b>" + a + "</b>";
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(pat)) return true;
            }
        }
        return false;
    }

    public static boolean hw7(boolean A, boolean B) {
        return !(A ^ B); //or just A == B
    }
}
