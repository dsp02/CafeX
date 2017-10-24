package com.jumar.cafe

/**
  * This trait represents the details required to place an item on the menu.
  */
sealed trait MenuItem {
  def name: String
  def isHot: Boolean
  def price: BigDecimal

  override def toString: String = s"$name, $isHot, $price"
}

case object Cola extends MenuItem {
  override def name = "Cola"

  override def isHot = false

  override def price = 0.5
}

case object Coffee extends MenuItem {
  override def name = "Coffee"

  override def isHot = true

  override def price = 1.00
}

case object CheeseSandwich extends MenuItem {
  override def name = "Cheese Sandwich"

  override def isHot = false

  override def price = 2.00
}

case object SteakSandwich extends MenuItem {
  override def name = "Steak Sandwich"

  override def isHot = true

  override def price = 4.5
}