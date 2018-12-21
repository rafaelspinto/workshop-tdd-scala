package workshop.payment

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PaymentBrokerTest extends FunSuite with MockFactory {

  var wallet = stub[Wallet]
  var provider = stub[Provider]
  var broker = new PaymentBroker(wallet, provider)

  test("pay: if wallet has funds and provider is available and deposit succeeded returns true") {
    val amount = 10
    val balance = 10

    (wallet.getBalance _).when().returns(balance)
    (provider.isAvailable _).when().returns(true)
    (provider.deposit _).when(wallet.getId(), amount).returns(true)

    assert(broker.pay(amount))
  }

  test("pay: if wallet does not have funds throws InsufficientFundsException") {
    val amount = 10
    val balance = 0

    (wallet.getBalance _).when().returns(balance)
    (provider.isAvailable _).when().returns(true)
    (provider.deposit _).when(wallet.getId(), amount).returns(true)

    assertThrows[InsufficientFundsException] {
      broker.pay(amount)
    }
  }

  test("pay: if provider is not available throws ProviderNotAvailableException") {
    val amount = 10
    val balance = 20

    (wallet.getBalance _).when().returns(balance)
    (provider.isAvailable _).when().returns(false)
    (provider.deposit _).when(wallet.getId(), amount).returns(true)

    assertThrows[ProviderNotAvailableException] {
      broker.pay(amount)
    }
  }
}