package implementation

object PricedBasket {
  val prices = List(("AAA", 120), ("BB", 45), ("A", 50), ("B", 30), ("C", 20), ("D", 15))

  def unapply(basket: Basket) = {
    def matchItems(items: String, price: Int) = {
      val sortedContents = basket.contents.sorted

      if (sortedContents.startsWith(items))
        Some(Basket(sortedContents.substring(items.length())), price)
      else None
    }

    matchItems("AAA", 120) orElse
      matchItems("BB", 45) orElse
      matchItems("A", 50) orElse
      matchItems("B", 30) orElse
      matchItems("C", 20) orElse
      matchItems("D", 15)
  }
}