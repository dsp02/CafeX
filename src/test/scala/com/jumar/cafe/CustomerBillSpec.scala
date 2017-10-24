package com.jumar.cafe

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Derek on 24/10/2017.
  */
class CustomerBillSpec extends FlatSpec with Matchers {

  "The customer's bill" should "include the cost of each menu item plus any applicable service charges" in {
    assert(Order.calculateBill(List(Coffee, CheeseSandwich)) == 3.30)
  }
  it should "not have a service charge for a cold drink" in {
    assert(Order.calculateBill(List(Cola)) == 0.50)
  }
  it should "not have a service charge for a hot drink" in {
    assert(Order.calculateBill(List(Coffee)) == 1.00)
  }
  it should "have a service charge of 10% for cold  food" in {
    assert(Order.calculateBill(List(CheeseSandwich)) == 2.20)
  }
  it should "have a service charge of 20% hot food" in {
    assert(Order.calculateBill(List(SteakSandwich)) == 5.40)
  }
  it should "have a service charge of 10% for cold food and cold drink" in {
    assert(Order.calculateBill(List(Cola, CheeseSandwich)) == 2.75)
  }
  it should "have a service charge of 10% for cold food and a hot drink" in {
    assert(Order.calculateBill(List(Coffee, CheeseSandwich)) == 3.30)
  }
  it should "have a service charge of 20% for hot food and a cold drink" in {
    assert(Order.calculateBill(List(Cola, SteakSandwich)) == 6.00)
  }
  it should "have a service charge of 20% for hot food and a hot drink" in {
    assert(Order.calculateBill(List(Coffee, SteakSandwich)) == 6.60)
  }
  it should "have a service charge of 20% for 2 hot food orders" in {
    assert(Order.calculateBill(List(SteakSandwich, SteakSandwich)) == 10.80)
  }
/*  it should "be unable to calculate an order with nothing on it" in {
    assertThrows[IllegalArgumentException] {
      assert(Order.calculateBill(List[MenuItem]()))
    }
  }*/
}
