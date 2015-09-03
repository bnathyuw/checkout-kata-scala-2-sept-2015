package implementation

object BasketWithKnownItem {
  private val prices = List(("AAA", 120), ("BB", 45), ("A", 50), ("B", 30), ("C", 20), ("D", 15))

  def unapply(basket: Basket) = prices.collectFirst {
    case (items, value) if contains(basket, items) => (Basket(rest(basket, items)), value)
  }

  def rest(basket: Basket, items: String): String = basket match {
    case Basket(contents) => contents.sorted.substring(items.length())
  }

  def contains(basket: Basket, items: String): Boolean = basket match {
    case Basket(contents) => contents.sorted.startsWith(items)
  }
}