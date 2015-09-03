package implementation

class Basket(contents: String){
  def without(items: String): Basket = {
    new Basket(contents.sorted.substring(items.length()))
  }

  def contains(items: String): Boolean = {
    contents.sorted.startsWith(items)
  }
}