package com.jumar

/**
  * Created by Derek on 24/10/2017.
  */
package object cafe {

  /**
   * Maximum service charge applicable in this Cafe.
   */
  val MaxServiceCharge = 20.0

  /**
    * The Cafe's menu.
    */
  val menu: Map[String, MenuItem] = Map(
    Cola.name -> Cola,
    Coffee.name -> Coffee,
    CheeseSandwich.name -> CheeseSandwich,
    SteakSandwich.name -> SteakSandwich
  )

}
