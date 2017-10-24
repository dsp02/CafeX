package com.jumar.cafe

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Derek on 24/10/2017.
  */
class ServiceChargeSpec extends FlatSpec with Matchers {

  val MaxServiceCharge = 20.0

  val drinksOrder = List(Cola, Coffee)
  val coldFoodOrder = List(CheeseSandwich, CheeseSandwich)
  val hotFoodOrder = List(SteakSandwich, SteakSandwich, SteakSandwich)

  val coldDrinkAndColdFoodOrder = List(Cola, CheeseSandwich)
  val coldDrinkAndHotFoodOrder = List(Cola, SteakSandwich)

  val hotDrinkAndColdFoodOrder = List(Coffee, CheeseSandwich)
  val hotDrinkAndHotFoodOrder = List(Coffee, SteakSandwich)

  val coldAndHotFoodOrder = List(CheeseSandwich, SteakSandwich)

  val emptyOrder = List[MenuItem]()

  "Service Charge" should "not be applied to just a drinks order" in {
    assert(Order.serviceChargeApplicable(drinksOrder, 5.00, MaxServiceCharge) == 0.00)
  }
  it should "be applied at 10% to a cold food order" in {
    assert(Order.serviceChargeApplicable(coldFoodOrder, 10.00, MaxServiceCharge) == 1.00)
  }
  it should "be applied at 20% to a hot food order" in {
    assert(Order.serviceChargeApplicable(hotFoodOrder, 10.00, MaxServiceCharge) == 2.00)
  }
  it should "be applied at 10% to a cold drink and cold food order" in {
    assert(Order.serviceChargeApplicable(coldDrinkAndColdFoodOrder, 20.00, MaxServiceCharge) == 2.00)
  }
  it should "be applied at 20% to a cold drink and hot food order" in {
    assert(Order.serviceChargeApplicable(coldDrinkAndHotFoodOrder, 20.00, MaxServiceCharge) == 4.00)
  }
  it should "be applied at 10% to a hot drink and cold food order" in {
    assert(Order.serviceChargeApplicable(hotDrinkAndColdFoodOrder, 20.00, MaxServiceCharge) == 2.00)
  }
  it should "be applied at 20% to a hot drink and hot food order" in {
    assert(Order.serviceChargeApplicable(hotDrinkAndHotFoodOrder, 20.00, MaxServiceCharge) == 4.00)
  }
  it should "be applied at 20% to cold food and hot food order" in {
    assert(Order.serviceChargeApplicable(coldAndHotFoodOrder, 20.00, MaxServiceCharge) == 4.00)
  }
  it should "have max service charge of £20 applied to cold food orders over 200" in {
    assert(Order.serviceChargeApplicable(coldFoodOrder, 201.00, MaxServiceCharge) == 20.00)
  }
  it should "have just less than service charge of £20 applied to cold food orders under 200" in {
    assert(Order.serviceChargeApplicable(coldFoodOrder, 199.00, MaxServiceCharge) == 19.90)
  }
  it should "have max service charge of £20 applied to hot food orders over 100" in {
    assert(Order.serviceChargeApplicable(hotFoodOrder, 101.00, MaxServiceCharge) == 20.00)
  }
  it should "have just less than service charge of £20 applied to hot food orders under 200" in {
    assert(Order.serviceChargeApplicable(hotFoodOrder, 99.00, MaxServiceCharge) == 19.80)
  }
  it should "not be applied to an empty order" in {
    assertThrows[IllegalArgumentException] {
      Order.serviceChargeApplicable(emptyOrder, 20.00, MaxServiceCharge) == 0.00
    }
  }
}
