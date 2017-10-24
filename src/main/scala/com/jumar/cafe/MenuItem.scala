package com.jumar.cafe

/**
  * Created by Derek on 24/10/2017.
  */
trait MenuItem {
  def name: String
  def isHot: Boolean
  def price: BigDecimal
}

case object Cola extends MenuItem {
  override def name = "Cola"

  override def isHot = false

  override def price = 0.5
}