package com.jumar.cafe

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Derek on 24/10/2017.
  */
class OrderSpec extends FlatSpec with Matchers {

  val cola = List(Cola)
  val coffee = List(Coffee)
  val cheeseSandwich = List(CheeseSandwich)
  val steakSandwich = List(SteakSandwich)

  val emptyList  = List[MenuItem]()

  "A single Cola order" should "cost 50p" in {
    assert(Order.total(cola) == 0.50)
  }

  "A single Coffee order" should "cost £1.00" in {
    assert(Order.total(coffee) == 1.00)
  }

  "A single Cheese Sandwich order" should "cost £2.00" in {
    assert(Order.total(cheeseSandwich) == 2.00)
  }

  "A single Steak Sandwich order" should "cost £4.50" in {
    assert(Order.total(steakSandwich) == 4.50)
  }

  "An empty order" should "cost £0.00" in {
    assert(Order.total(emptyList) == 0.0)
  }

  "A cola, coffee, cheese sandwich" should "cost £3.50" in {
    assert(Order.total(cola ::: coffee ::: cheeseSandwich) == 3.5)
  }

  "A cola, coffee, cheese sandwich, steak sandwich" should "cost £8.00" in {
    assert(Order.total(cola ::: coffee ::: cheeseSandwich ::: steakSandwich) == 8.00)
  }



}
