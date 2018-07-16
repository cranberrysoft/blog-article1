package com.cranberrysoft.blog.article.problem1

import com.cranberrysoft.blog.article.problem1.functional.FunctionalSolution
import com.cranberrysoft.blog.article.problem1.imperative.ImperativeSolution
import com.cranberrysoft.blog.article.problem2.Sol
import org.scalatest._

class SolutionTest extends fixture.FlatSpec with GivenWhenThen {

  type FixtureParam = Solution

  override def withFixture(test: OneArgTest) = {
    //FIXME when some of the tests fails we don't know for which fixture
    test(new ImperativeSolution)
    test(new FunctionalSolution)
    test(Sol())
  }

  "findMaxPrime" should "return 2 if there is no primes for the given number" in { (sol: Solution) =>
    Given("no primes")
    val noPrime = 1

    When("findMaxPrime is called")
    val findMaxResult: Int = sol.findMaxPrime(noPrime)

    Then("returns the smalles prime")
    assert(findMaxResult === 2)
  }



  "findMaxPrime" should "return first prime if there is only prime number for the given number" in { (sol: Solution) =>
    Given("one prime")
    val onePrime = 2

    When("findMaxPrime is called")
    val findMaxResult: Int = sol.findMaxPrime(onePrime)

    Then("returns first prime")
    assert(findMaxResult === 2)
  }


  it should "return maximum prime number if there is more than one prime number for the given number" in { (sol: Solution) =>
    Given("one digit number")
    var num = 9 //primes 2,3,5,7

    When("findMaxPrime is called for one digit number")
    var findMaxResult = sol.findMaxPrime(num)

    Then("returns maximum prime")
    assert(findMaxResult === 7)

    Given("two digit number")
    num = 11 //primes 2,3,5,7,11

    When("findMaxPrime is called for two digit number")
    findMaxResult = sol.findMaxPrime(num)

    Then("returns maximum prime")
    assert(findMaxResult == 7)

  }

}
