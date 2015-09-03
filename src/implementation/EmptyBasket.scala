package implementation

object EmptyBasket {
  def unapply(basket: Basket) = basket.isEmpty
}
