package workshop.payment

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CustomWalletTest extends FunSuite {

  test("add: if amount is negative throws NegativeAmountException") {
    // Arrange
    val amount = -10
    val wallet: CustomWallet = new CustomWallet(0)

    // Act && Assert
    assertThrows[NegativeAmountException] {
      wallet.add(amount)
    }
  }

  test("add: if amount is positive returns positive balance") {
    val amount = 10
    val balance = 11
    val wallet: CustomWallet = new CustomWallet(balance)
    assert(wallet.add(amount) == wallet.getBalance)
  }

  test("add: if amount is greater than allowed throws MaxAmountExceededException") {
    val amount = 11
    val wallet: CustomWallet = new CustomWallet(0, 10)
    assertThrows[MaxAmountExceededException] {
      wallet.add(amount)
    }
  }

  test("remove: if amount is greater than balance throws NotEnoughFundsException") {
    val amount = 11
    val wallet: CustomWallet = new CustomWallet(0)
    assertThrows[NotEnoughFundsException] {
      wallet.remove(amount)
    }
  }

  test("remove: if amount is lower or equal than balance returns positive balance") {
    val amount = 9
    val balance = 11
    val wallet: CustomWallet = new CustomWallet(balance)
    assert(wallet.remove(amount) == wallet.getBalance)
  }
}
