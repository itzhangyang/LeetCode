package com.leetcode.jeffery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        System.out.println("Input a button!");
        // accept an input string
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String button = r.readLine();
        printButton(button);
    }

    public static  void printButton(String button) {
        System.out.println("Button: " + button);
    }
}
