package ru.honsage.practice;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(2, 3, 4, 8, 7, 8, 13, 9));
        try {
            System.out.println("Source array: " + array);
            System.out.println("Even: " + NumericFilter.filterEven(array));
            System.out.println("Odd: " + NumericFilter.filterOdd(array));
            System.out.println("Fibonacci: " + NumericFilter.filterFibonacci(array));
            System.out.println("Primes: " + NumericFilter.filterPrimes(array));
        } catch (NumericFilter.ArrayException _) {
            System.out.println("Передан пустой или некорректный массив");
        }
    }
}