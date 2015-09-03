package implementation

object PricedBasket {
  private val prices = List(("AAA", 120), ("BB", 45), ("A", 50), ("B", 30), ("C", 20), ("D", 15))

  def unapply(basket: Basket) = {

    prices.foldLeft(None: Option[(Basket, Int)]) {
      case (Some(a), _) => Some(a)
      case (_, (items, price)) if contains(basket, items) => Some(Basket(rest(basket, items)), price)
      case _ => None
    }
  }

  def rest(basket: Basket, items: String): String = basket match {
    case Basket(contents) => contents.sorted.substring(items.length())
  }

  def contains(basket: Basket, items: String): Boolean = basket match {
    case Basket(contents) => contents.sorted.startsWith(items)
  }
}