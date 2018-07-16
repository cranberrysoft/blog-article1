package com.cranberrysoft.blog.article.problem2

import com.cranberrysoft.blog.article.problem1.Solution

object Sol {
  def apply(): Sol = new Sol()
}

class Sol extends Solution {

  override def findMaxPrime(n: Int): Int = findMax(n, primes, sumOfDigits)

  private def findMax(n: Int, primes: PartialFunction[Int, Seq[Int]], max: Int => Int) = primes.applyOrElse(n, minPrime).maxBy(max)

  private def sumOfDigits(number: Int) = number.toString.map(_.asDigit).sum

  private def minPrime: PartialFunction[Int, Seq[Int]] = {
    case _ => Seq(2)
  }

  private def primes: PartialFunction[Int, Seq[Int]] = {
    case n: Int if n >= 2 => (2 to n) filter prime
  }

  private def prime(candidate: Int) = (2 until candidate).forall(candidate % _ != 0)

}
