package workshop.payment

class PaymentBroker(wallet: Wallet, provider: Provider) {
  def pay(amount: Int): Boolean = {
    if (wallet.getBalance < amount) {
      throw new InsufficientFundsException
    }

    if (!provider.isAvailable) {
      throw new ProviderNotAvailableException
    }
    true
  }
}
