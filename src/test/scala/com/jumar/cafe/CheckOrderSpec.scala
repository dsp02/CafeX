package com.jumar.cafe

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Derek on 24/10/2017.
  */
class CheckOrderSpec extends FlatSpec with Matchers {

  val cola = List("Cola")
  val coffee = List("Coffee")
  val cheeseSandwich = List("Cheese Sandwich")
  val steakSandwich = List("Steak Sandwich")

  val emptyOrder  = List[String]()
  val emptyMenu: Map[String, MenuItem] = Map()

  "An menu" should "have menu items on it to choose from" in {
    assertThrows[IllegalArgumentException] {
      Order.check(cola, emptyMenu)
    }
  }

  "An order" should "not be empty" in {
    assertThrows[IllegalArgumentException] {
      Order.check(emptyOrder, menu)
    }
  }
    it should "be possible to order just a cola" in {
      assert(Order.check(cola, menu) == List(Cola))
    }
    it should "be possible to order just a coffee" in {
      assert(Order.check(coffee, menu) == List(Coffee))
    }
    it should "be possible to order just a cheese sandwich" in {
      assert(Order.check(cheeseSandwich, menu) == List(CheeseSandwich))
    }
    it should "be possible to order just a steak sandwich" in {
      assert(Order.check(steakSandwich, menu) == List(SteakSandwich))
    }
    it should "be possible to order a cola and coffee" in {
      assert(Order.check(cola:::coffee, menu) == List(Cola, Coffee))
    }
    it should "be possible to order just a coffee and a cheese sandwich" in {
      assert(Order.check(coffee:::cheeseSandwich, menu)== List(Coffee, CheeseSandwich) )
    }
    it should "be possible to order just a cola and steak sandwich" in {
      assert(Order.check(cola:::steakSandwich, menu) == List(Cola, SteakSandwich))
    }
    it should "be possible to order just a cheese sandwich and steak sandwich" in {
      assert(Order.check(cheeseSandwich:::steakSandwich, menu) == List(CheeseSandwich, SteakSandwich))
    }
    it should "be possible to 2 coffees" in {
      assert(Order.check(coffee:::coffee, menu) == List(Coffee, Coffee))
    }
    it should "be possible to 2 cheese sandwiches" in {
      assert(Order.check(cheeseSandwich:::cheeseSandwich, menu) == List(CheeseSandwich, CheeseSandwich))
    }
    it should "be possible to 5 cola" in {
      assert(Order.check(cola:::cola:::cola:::cola:::cola, menu) == List(Cola, Cola, Cola, Cola, Cola))
    }
}
