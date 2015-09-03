package tests
import implementation.Basket
import implementation.Checkout
import org.scalatest._

class CheckoutSpec extends FlatSpec with Matchers {
  "an empty basket" should "cost nothing" in {
    Checkout.priceOf(new Basket("")) should be (0)
  }

  "a basket containing one A" should "cost 50" in {
    Checkout.priceOf(new Basket("AE")) should be (50)
  }

  "a basket containing one A and one B" should "cost 80" in {
    Checkout.priceOf(new Basket("AB")) should be (80)
  }

  "a basket containing one B and one A" should "cost 80" in {
    Checkout.priceOf(new Basket("BA")) should be (80)
  }

  "a basket containing A B and C" should "cost 100" in {
    Checkout.priceOf(new Basket("ABC")) should be (100)
  }

  "a basket containing A B C and D" should "cost 115" in {
    Checkout.priceOf(new Basket("DCBA")) should be (115)
  }

  "a basket containing three A" should "cost 120" in {
    Checkout.priceOf(new Basket("AAA")) should be (120)
  }

  "a basket containing two special offer bundles" should "cost 165" in {
    Checkout.priceOf(new Basket("ABABA")) should be (165)
  }
}
