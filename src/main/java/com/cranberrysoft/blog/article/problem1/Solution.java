package com.cranberrysoft.blog.article.problem1;

public interface Solution {

    /**
     * For parameter n look for all prime numbers between 2 to n and return the one
     * which has the biggest sum of digits
     *  e.g input 11 then all prime numbers <= 11 are 2, 3, 5, 7, 11
     *  then output should be 7 since 7 > 5 > 3 > 2 (because 11 is transformed to sum 1+1)
     * @param n
     * @return 2 if there is no prime number elsewhere returns maximum
     */
    int findMaxPrime(int n);
}
