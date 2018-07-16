package com.cranberrysoft.blog.article.problem1.functional;

import com.cranberrysoft.blog.article.problem1.Solution;

import java.util.Collection;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class FunctionalSolution implements Solution {

    @Override
    public int findMaxPrime(int n) {
        return findMax(n, primes, sumOfDigits);
    }

    private int findMax(int n, Function<Integer, Collection<Integer>> primes, ToIntFunction<Integer> max) {
        return primes.apply(n).stream()
                .collect(maxBy(comparingInt(max))).orElse(2);
    }

    private IntPredicate prime = candidate -> IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);

    private Function<Integer, Collection<Integer>> primes = n ->
            IntStream.rangeClosed(2, n).filter(prime).boxed().collect(toList());

    private ToIntFunction<Integer> sumOfDigits = number -> String.valueOf(number).chars()
            .map(c -> Integer.valueOf(String.valueOf((char) c)))
            .sum();

}
