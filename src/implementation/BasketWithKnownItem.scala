package implementation

object BasketWithKnownItem {
  private val prices = List(("AAA", 120), ("BB", 45), ("A", 50), ("B", 30), ("C", 20), ("D", 15))

  def unapply(basket: Basket) = prices.collectFirst {
    case (items, value) if basket contains items => (basket without items, value)
  }
}

