package thirteenth.roman_to_integer

object RomanToInteger extends App {

  println(getInteger("MMMCMXCIX"))
  println(getInteger("MDCCC"))

  def getInteger(roman: String): Int = {
    if (roman < "I" || roman > "MMMCMXCIX") {
      return 0
    }
    var num = 0
    var tmp = 0
    for (r <- roman) {
      if (tmp == 0) {
        tmp = RomanChart.getNumber(r.toString)
      } else {
        if (tmp < RomanChart.getNumber(r.toString)) {
          num += (RomanChart.getNumber(r.toString) - tmp)
          tmp = 0
        } else {
          num += tmp
          tmp = RomanChart.getNumber(r.toString)
        }

      }
    }
    if (tmp > 0) {
      num += tmp
    }
    num
  }


  /**
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   */
}


object RomanChart extends Enumeration {
  val I = Value(1)
  val V = Value(5)
  val X = Value(10)
  val L = Value(50)
  val C = Value(100)
  val D = Value(500)
  val M = Value(1000)

  def getChart(num: Int): String = {
    num match {
      case 1 => "I"
      case 5 => "V"
      case 10 => "X"
      case 50 => "L"
      case 100 => "C"
      case 500 => "D"
      case 1000 => "M"
      case _ => "Y"
    }
  }

  def getNumber(roman: String): Int = {
    roman match {
      case "I" => 1
      case "V" => 5
      case "X" => 10
      case "L" => 50
      case "C" => 100
      case "D" => 500
      case "M" => 1000
      case _ => 0
    }
  }
}
