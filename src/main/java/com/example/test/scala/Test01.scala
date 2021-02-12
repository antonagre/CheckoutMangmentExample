package com.example.test.scala
import io.cucumber.scala.{EN, ScalaDsl}


class Test01 extends ScalaDsl with EN{
  var test = new Requests
  var idOrder = 0

  Given("""a new checkout with code {int}""") { (id: Int) =>
    test.postRequest("/order/create?id="+id)
    idOrder=id
  }

  Given("""the product {string} price is {int}""") { (productName: String, price: Int) =>
    test.postRequest("/product/add?name="+productName+"&prezzo="+price)
  }

  When("""I add a product with name {string}""") { (name: String) =>
    println(name)
    test.postRequest("/order/add?id="+idOrder+"&name="+name)
  }

  Then("""the checkout has {int} EUR in the total value""") { (tot: Int) =>
    val total=test.getRequest("/order/total/get?id="+idOrder).toString.toInt
    print("total "+total+" expected "+tot)
    test.postRequest("/order/remove?id="+idOrder)
    assert(tot==total)
  }
}
