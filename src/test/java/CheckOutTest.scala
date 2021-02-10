import scalaj.http.{Http, HttpOptions, HttpResponse}

object CheckOutTest extends App{
  val url = "http://localhost:8080/checkout/order/get?id=1"
  val http = Http(url)
///    .postData("10")
//    .headers(headers)
    .option(HttpOptions.method("GET"))
    .option(HttpOptions.connTimeout(0))
    .option(HttpOptions.readTimeout(0))
  http.option(HttpOptions.allowUnsafeSSL)
  println(http.asString.body)

}

