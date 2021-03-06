package workshop.payment

class CustomWallet(var balance: Int, maxAmount: Int = 1000) extends Wallet{
  def remove(amount: Int): Int = {
    if(amount > balance) {
      throw new NotEnoughFundsException
    }
    balance -= amount
    balance
  }

  def add(amount: Int): Int = {
    if(amount < 0 ) {
      throw new NegativeAmountException
    }
    if(amount > maxAmount) {
      throw new MaxAmountExceededException
    }
    balance += amount
    balance
  }

  override def getBalance: Int = balance
}
