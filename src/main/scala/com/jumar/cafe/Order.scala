package com.jumar.cafe

/**
  * Created by Derek on 24/10/2017.
  */
object Order {

  /**
    * Provides a total sum for the ordered items.
    * @param items to be ordered of the menu
    * @return the amount payable
    */
  def total(items: List[MenuItem]) = items.map(_.price).sum
}
