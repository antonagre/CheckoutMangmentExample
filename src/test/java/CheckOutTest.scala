import scalaj.http.{Http, HttpOptions, HttpResponse}
import org.json4s.Xml.toJson

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

  val soapBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n                  xmlns:gs=\"wathever\">\n    <soapenv:Header/>\n    <soapenv:Body>\n        <gs:getProductRequest>\n            <gs:name>Aceite</gs:name>            \n        </gs:getProductRequest>\n    </soapenv:Body>\n</soapenv:Envelope>"
  val http2 = Http("http://localhost:8080/ws")
    .postData(soapBody)
    .header("Content-Type","text/xml ; charset=utf-8")
    .option(HttpOptions.method("GET"))
    .option(HttpOptions.connTimeout(0))
    .option(HttpOptions.readTimeout(0))
  http2.option(HttpOptions.allowUnsafeSSL)
  println(toJson(http2.asString.body))
}

