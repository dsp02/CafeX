package com.jumar.cafe

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Derek on 24/10/2017.
  */
class ProcessOrderSpec extends FlatSpec with Matchers {

  "An Order" should "have an associated cost to the customer" in {
    assert(Order.process(Array[String]("Cola")) == 0.50)
  }
  it should "have a cost of £1.00 for a Coffee" in {
    assert(Order.process(Array[String]("Coffee")) == 1.00)
  }
  it should "have a cost of £2.20 for a Cheese Sandwich" in {
    assert(Order.process(Array[String]("Cheese Sandwich")) == 2.20)
  }
  it should "have a cost of £2.20 for a Steak Sandwich" in {
    assert(Order.process(Array[String]("Steak Sandwich")) == 5.40)
  }
  it should "have a cost of £1.50 for a Cola and a Coffee with a unexplained item " in {
    assert(Order.process(Array[String]("Cola", "", "Coffee")) == 1.50)
  }
  it should "not give a price for Pasta as not on the menu, £1.50 for a Cola and a Coffee." in {
    assert(Order.process(Array[String]("Cola", "Pasta", "Coffee")) == 1.50)
  }
  it should "not be able to process an empty string order" in {
    assertThrows[IllegalArgumentException] {
      (Order.process(Array[String]("")))
    }
  }
  it should "not be able to process a null order" in {
    assertThrows[IllegalArgumentException](Order.process(Array[String]()))
  }
}
