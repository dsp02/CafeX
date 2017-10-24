package com.jumar.cafe

/**
  * Created by Derek on 24/10/2017.
  */
object Order {

  def main(args: Array[String]): Unit = {
    val customerOrder = args.toList
    val totalPrice = if (!customerOrder.isEmpty) placeOrder(customerOrder) else 0.0
    println(s"Total price: $totalPrice")
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
    * Provides a total sum for the ordered items.
    * @param items to be ordered of the menu
    * @return the amount payable
    */
  def total(items: List[MenuItem]) = items.map(_.price).sum

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

}
