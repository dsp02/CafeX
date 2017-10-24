package com.jumar.cafe

/**
  * * This trait represents the service charge applicable to the order.
  */

trait ServiceCharge {
  def percent: BigDecimal = 0.0
}
