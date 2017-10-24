package com.jumar.cafe

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Derek on 24/10/2017.
  */
class MenuItemSpec extends FlatSpec with Matchers {

  "Cola drink" should "be an item on the menu" in {
    assert(Cola.name == "Cola")
  }
  it should "be cold" in {
    assert(Cola.isHot == false)
  }
  it should "be priced at 50p" in {
    assert(Cola.price == 0.50)
  }

  "Coffee drink" should "be an item on the menu" in {
    assert(Coffee.name == "Coffee")
  }
  it should "be hot" in {
    assert(Coffee.isHot == true)
  }
  it should "be priced at £1.00" in {
    assert(Coffee.price == 1.00)
  }

  "A Cheese Sandwich" should "be an item on the menu" in {
    assert(CheeseSandwich.name == "Cheese Sandwich")
  }
  it should "be cold" in {
    assert(CheeseSandwich.isHot == false)
  }
  it should "be priced at £2.00" in {
    assert(CheeseSandwich.price == 2.00)
  }

  "A Steak Sandwich" should "be an item on the menu" in {
    assert(SteakSandwich.name == "Steak Sandwich")
  }
  it should "be hot" in {
    assert(SteakSandwich.isHot == true)
  }
  it should "be priced at £4.50" in {
    assert(SteakSandwich.price == 4.50)
  }

}
