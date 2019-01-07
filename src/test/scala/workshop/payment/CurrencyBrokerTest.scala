package workshop.payment

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CurrencyBrokerTest extends FunSuite with MockFactory{

  test("convertToBitCoin: if amount is greater than balance throws InsufficientFundsException") {
    val amount = 10
    val wallet = stub[CustomWallet]
    (wallet.remove _).when(amount).throws(new NotEnoughFundsException)

    val broker: CurrencyBroker = new CurrencyBroker(wallet)
    assertThrows[InsufficientFundsException] {
      broker.convertToBitCoin(amount)
    }
  }

  test("convertToBitCoin: if amount is lower or equal than balance true") {
    val amount = 10
    val wallet = stub[CustomWallet]
    (wallet.remove _).when(amount).returns(1)

    val broker: CurrencyBroker = new CurrencyBroker(wallet)

    assert(broker.convertToBitCoin(amount))
  }
}
