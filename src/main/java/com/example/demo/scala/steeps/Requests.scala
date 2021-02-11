package com.example.demo.scala.steeps

import scalaj.http.{Http, HttpOptions}

class Requests{
  val url = "http://localhost:8081/checkout"

  def getRequest(endpoint:String): Any = {
    val http = Http(url+endpoint)
      .option(HttpOptions.method("GET"))
      .option(HttpOptions.connTimeout(0))
      .option(HttpOptions.readTimeout(0))
      .option(HttpOptions.allowUnsafeSSL)
    return http.asString.body
  }

  def postRequest(endpoint:String,data:String)= {
    val http = Http(url+endpoint)
      .postData(data)
      .option(HttpOptions.method("POST"))
      .option(HttpOptions.connTimeout(0))
      .option(HttpOptions.readTimeout(0))
      .option(HttpOptions.allowUnsafeSSL)
    println(http.asString.body)
  }

  def postRequest(endpoint:String)={
    val http = Http(url+endpoint)
      .option(HttpOptions.method("POST"))
      .option(HttpOptions.connTimeout(0))
      .option(HttpOptions.readTimeout(0))
      .option(HttpOptions.allowUnsafeSSL)
    println(http.asString)
  }

  def postRequestSoap(endpoint: String, soapBody:String): Unit ={
    val http2 = Http("http://localhost:8080/ws")
    .postData(soapBody)
    .header("Content-Type","text/xml ; charset=utf-8")
    .option(HttpOptions.method("GET"))
    .option(HttpOptions.connTimeout(0))
    .option(HttpOptions.readTimeout(0))
    http2.option(HttpOptions.allowUnsafeSSL)
    println(http2.asString.body)
  }

}

