package com.example.test

import io.cucumber.scala.{EN, ScalaDsl}

class Test01 extends ScalaDsl with EN {
  var test = new Requests
  var idOrder = 0

  Given("""a new checkout with code {int}""") { (int1: Int) =>
    test.postRequest("/order/create?id="+int1)
    idOrder=int1
  }

  Given("""the product {string} price is {int}""") { (string: String, int1: Int) =>
    test.postRequest("/product/add?name="+string+"&prezzo="+int1)
  }

  When("""I add a product with name {string}""") { (string: String) =>
    println(string)
    test.postRequest("/order/add?id="+idOrder+"&name="+string)
  }

  Then("""the checkout has {int} EUR in the total value""") { (int1: Int) =>
    val total=test.getRequest("/order/total/get?id="+idOrder).toString.toInt
    println("total "+total+" expected "+int1)
    test.postRequest("/order/remove?id="+idOrder)
    assert(int1==total)///FALSE
  }



}
