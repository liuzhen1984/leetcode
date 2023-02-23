package fraction_to_recurring_decimal

import scala.collection.mutable

object Solution extends App {
    println(fractionToDecimal(1, 2))
    println(fractionToDecimal(2, 1))
//    println(fractionToDecimal(4, 333))
    println(fractionToDecimal(10, 3))
    println(fractionToDecimal(10, 9))
  //  println(fractionToDecimal(1, 6))
//  println(fractionToDecimal(1, 19))
  //  println(fractionToDecimal(1, 17))


  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    var sign = ""
    if (numerator * denominator < 0) {
      sign = "-"
    }

    var formatString = "%.10f"

    var result = formatString.format(BigDecimal(Math.abs(numerator.toDouble))/BigDecimal(Math.abs(denominator).toDouble)).split("\\.")

    if (result.length==1 || result(1) == "0") {
      return result(0)
    }
    println(s"$numerator,$denominator,${result(0)},${result(1)}")

    val res = mutable.ListBuffer(sign + result(0), ".")
    val tmp = mutable.Map[String, Int]()
    var remainder = result(1)
    while (remainder.toLong > 0 && !tmp.contains(result(1))) {
      tmp.put(result(1), res.length)
      result = formatString.format(BigDecimal(result(1).toDouble * 10)/ BigDecimal(Math.abs(denominator))).split("\\.")
      res.append(result(0))
      if(result.length==1){
        remainder = "-1"
      }else{
        remainder = result(1)
      }
    }
    if(tmp.contains(remainder)){
      val idx = tmp.get(remainder).get
      res.insert(idx,"(")
      res.append(")")
    }
    res.mkString("")
  }


}
