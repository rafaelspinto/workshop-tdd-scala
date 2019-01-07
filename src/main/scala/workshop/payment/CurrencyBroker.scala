package workshop.payment

class CurrencyBroker(wallet: CustomWallet) {
  def convertToBitCoin(amount: Int): Boolean = {
    try {
      wallet.remove(amount) > 0
    } catch {
      case _: NotEnoughFundsException => throw new InsufficientFundsException
    }
  }
}
