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
}
