package com.jumar.cafe

/**
  * Created by Derek on 24/10/2017.
  *
  * Processes a raw customer order placed in Cafe X.
  * It displays the final bill for the order.
  *
  * Note:
  */
object Order {

  def main(rawOrder: Array[String]): Unit = {

    require(!rawOrder.isEmpty, "Unable to process an empty order")
    require(rawOrder != null, "Unable to process a null order")

    val totalPrice: BigDecimal = process(rawOrder)

    // display total order price.
    val scaledPrice = totalPrice.setScale(2)
    println(s"Total price: $scaledPrice")
  }

  /**
    * Process the customer's order and give them the total price.
    * @param order containing menu items
    * @return the total price of the order
    */
  def process(order: Array[String]): BigDecimal = {

    val customerOrder = order.toList

    val checkedOrder = check(customerOrder, menu)

    val orderPrice = calculateBill(checkedOrder)

    orderPrice
  }

  /**
    * Places the order.
    * @param order containing menu items
    * @return the total price of the order
    */
  def placeOrder(order: List[String]): BigDecimal  = {

    val checkedOrder = check(order, menu)

    val totalPrice = total(checkedOrder)

    totalPrice
  }

  /**
    * Calculates the bill total, this is the menu price plus any applicable service charges
    * @param order
    * @return the amount to charge the customer
    */
  def calculateBill(order: List[MenuItem]): BigDecimal = {

    val menuPrice: BigDecimal = total(order)

    val serviceCharge: BigDecimal = serviceChargeApplicable(order, menuPrice, MaxServiceCharge)

    val billTotal = menuPrice +  serviceCharge

    billTotal
  }

  /**
    * Provides a total sum for the ordered items.
    * @param items to be ordered of the menu
    * @return the amount payable
    */
  def total(items: List[MenuItem]): BigDecimal = items.map(_.price).sum

  /**
    * Checks the items ordered are actually on the menu.
    * Requires the order and menu to be non-empty.
    * @param items ordered
    * @param menu the cafe's menu
    * @return items which are on the menu
    */
  def check(items: List[String], menu: Map[String, MenuItem]): List[MenuItem] = {

    require(!items.isEmpty)
    require(!menu.isEmpty)

    items.filter(menu.contains).map(menu)
  }

  /**
    * Applies a service charge to the order.
    * No charge is applied to drinks.
    * A 10% charge is applied to cold food orders.
    * A 20% charge is applied to a hot foot orders.
    * The maximum service charge to be applied is £20.00
    * @param order to apply charge to.
    * @param price of the order (without service charge)
    * @param maxCharge that will be applied.
    * @return the service charge amount
    */
  def serviceChargeApplicable(order: List[MenuItem], price: BigDecimal, maxCharge: BigDecimal): BigDecimal = {

    require(!order.isEmpty)

    val percentToCharge = order.map(_.percent).max

    val amount = Math.min(maxCharge.toDouble, (price * percentToCharge).toDouble)

    amount
  }
}
