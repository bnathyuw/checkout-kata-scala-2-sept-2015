package implementation

object Checkout {
  def priceOf(basket: Basket, totalSoFar: Int = 0): Int = basket match {
    case BasketWithKnownItem(restOfBasket, priceOfMatchingItems) => priceOf(restOfBasket, totalSoFar + priceOfMatchingItems)
    case EmptyBasket() => totalSoFar
    case _ => throw new UnknownItemException()
  }
}