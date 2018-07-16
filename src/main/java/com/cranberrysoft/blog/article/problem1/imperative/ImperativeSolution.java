package com.cranberrysoft.blog.article.problem1.imperative;

import com.cranberrysoft.blog.article.problem1.Solution;

import java.util.ArrayList;
import java.util.Collection;

public class ImperativeSolution implements Solution {

    public int findMaxPrime(int n) {
        return findMax(findAllPrimes(n));
    }

    private Collection<Integer> findAllPrimes(int n) {
        final Collection result = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private int findMax(Collection<Integer> allPrimes) {
        int result = 2; //the smallest prime number

        int maximum = result; //the maximum prime number
        for (Integer prime : allPrimes) {

            int digitSum = 0;
            for (Integer digit : getDigits(prime)) {
                digitSum += digit;
            }

            if (digitSum > maximum) { //when sum of digits is greather than current one we have new result
                maximum = digitSum;
                result = prime;
            }
        }

        return result;
    }

    private Collection<Integer> getDigits(Integer number) {
        final Collection digits = new ArrayList<Integer>();
        for (char c : String.valueOf(number).toCharArray()) {
            digits.add(Integer.valueOf(String.valueOf(c)));
        }
        return digits;
    }

    private boolean isPrime(int n) {
        final boolean result = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return result;
    }
}
