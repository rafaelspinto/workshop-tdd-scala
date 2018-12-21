package workshop.payment

trait Provider {

  def deposit(id: Int, amount: Int): Boolean

  def isAvailable: Boolean
}
