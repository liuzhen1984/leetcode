package fraction_to_recurring_decimal

import scala.collection.mutable

object Solution extends App {
  //  println(fractionToDecimal(1, 2))
  //  println(fractionToDecimal(2, 1))
  //  println(fractionToDecimal(4, 333))
  //  println(fractionToDecimal(10, 3))
  //  println(fractionToDecimal(10, 9))
  //  println(fractionToDecimal(1, 6))
  //  println(fractionToDecimal(1, 19))
  //  println(fractionToDecimal(1, 17))
//  println(fractionToDecimal(-1, -2147483648))
//  println(fractionToDecimal(-2147483648, -1))
  println(fractionToDecimal(-2147483648, 1))


  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    var sign = ""

    var s =
    println( numerator.toLong * denominator.toLong )
    if (numerator.toLong * denominator.toLong < 0) {
      sign = "-"
    }


    var n: Long = Math.abs(numerator.toLong / denominator.toLong)
    println( n )

    var remainder: Long = Math.abs(numerator % denominator)

    if (remainder == 0) {
      return sign+n.toString
    }
    //        println(s"$numerator,$denominator,$n,$remainder")

    val res = mutable.ListBuffer(sign + n, ".")
    val tmp = mutable.Map[Long, Int]()
    while (remainder > 0 && !tmp.contains(remainder)) {
      tmp.put(remainder, res.length)
      n = Math.abs(remainder * 10 / denominator)
      remainder = Math.abs(remainder * 10 % denominator)
      //      println(s"$numerator,$denominator,$n,$remainder")

      res.append(n.toString)
    }
    if (tmp.contains(remainder)) {
      val idx = tmp.get(remainder).get
      res.insert(idx, "(")
      res.append(")")
    }
    res.mkString("")
  }


}
