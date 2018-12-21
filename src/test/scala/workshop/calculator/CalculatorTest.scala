package workshop.calculator

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CalculatorTest extends FunSuite {
  val calc = new Calculator()


  test("sum: if both numbers are Positive returns a positive number") {
    // Arrange
    val a = 10
    val b = 20

    // Act
    val result = calc.sum(a, b)

    //Assert
    assert(result > 0)
  }

  test("sum: if both numbers are negative returns a negative number") {
    val a = -10
    val b = -20

    assert(calc.sum(a, b) < 0)

  }

  test("sum: if numbers are opposite returns zero") {
    val a = -10
    val b = 10

    assert(calc.sum(a, b) == 0)
  }
}
