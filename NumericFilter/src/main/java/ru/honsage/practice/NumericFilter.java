package ru.honsage.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class NumericFilter {
    public static ArrayList<Boolean> eratosthenesSieve(int upperBound) {
        ArrayList<Boolean> sieve = new ArrayList<>(Collections.nCopies(upperBound + 1, true));
        sieve.set(0, false);
        sieve.set(1, false);
        for (int i = 2; i * i <= upperBound; ++i) {
            if (sieve.get(i)) {
                for (int j = i * i; j <= upperBound; j += i) {
                    sieve.set(j, false);
                }
            }
        }
        return sieve;
    }

    public static ArrayList<Integer> fibonacci(int upperBound) {
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        int i = 2;
        int last = fibonacci.get(i - 2) + fibonacci.get(i - 1);
//        while (fibonacci.getLast() < upperBound) {
//            fibonacci.add(fibonacci.get(i - 2) + fibonacci.get(i - 1));
//            i++;
//        }
        while (last <= upperBound) {
            fibonacci.add(last);
            i++;
            last = fibonacci.get(i - 2) + fibonacci.get(i - 1);
        }
        return fibonacci;
    }

    public static ArrayList<Integer> filterPrimes(ArrayList<Integer> array) throws ArrayException {
        Optional<Integer> max = array.stream().max(Integer::compareTo);
        if (max.isEmpty()) {
            throw new ArrayException("Array is Empty!");
        }
        ArrayList<Boolean> eratosthenesSieve = NumericFilter.eratosthenesSieve(max.get());
        return (ArrayList<Integer>) array.stream().filter(eratosthenesSieve::get).collect(Collectors.toList());
    }

    public static ArrayList<Integer> filterFibonacci(ArrayList<Integer> array) throws ArrayException {
        Optional<Integer> max = array.stream().max(Integer::compareTo);
        if (max.isEmpty()) {
            throw new ArrayException("Array is Empty!");
        }
        ArrayList<Integer> fibonacci = NumericFilter.fibonacci(max.get());
        return (ArrayList<Integer>) array.stream().filter(fibonacci::contains).collect(Collectors.toList());
    }

    public static ArrayList<Integer> filterEven(ArrayList<Integer> array) {
        return (ArrayList<Integer>) array.stream().filter(el -> el % 2 == 0).collect(Collectors.toList());
    }

    public static ArrayList<Integer> filterOdd(ArrayList<Integer> array) {
        return (ArrayList<Integer>) array.stream().filter(el -> el % 2 == 1).collect(Collectors.toList());
    }

    public static class ArrayException extends Exception {
        public ArrayException(String message) {
            super(message);
        }
    }
}
