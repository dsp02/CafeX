package com.jumar.cafe

/**
  * This trait represents the details required to place an item on the menu.
  */
sealed trait MenuItem extends ServiceCharge {
  def name: String
  def isHot: Boolean
  def price: BigDecimal

  override def toString: String = s"$name, $isHot, $price"
}

abstract class Drink extends MenuItem

abstract class Food extends MenuItem {
  override def percent: BigDecimal = if (isHot) 0.2 else 0.1
}

case object Cola extends MenuItem {
  override def name = "Cola"

  override def isHot = false

  override def price = 0.5
}

case object Coffee extends Drink {
  override def name = "Coffee"

  override def isHot = true

  override def price = 1.00
}

case object CheeseSandwich extends Food {
  override def name = "Cheese Sandwich"

  override def isHot = false

  override def price = 2.00
}

case object SteakSandwich extends Food {
  override def name = "Steak Sandwich"

  override def isHot = true

  override def price = 4.5
}