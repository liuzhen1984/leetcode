package thirteenth.roman_to_integer

object RomanToInteger extends App {


  def getInteger(num: String): Int = {
//    if(num<1 || num>3999){
//      return ""
//    }
//    var tmp: Int = num
//    var index = 1
//    val result = mutable.ArrayBuffer[String]()
//    while (tmp > 0) {
//      val value = tmp % 10
//      value match {
//        case 9 => result.insert(0, (RomanChart.getChart(index) + RomanChart.getChart(index * 10)))
//        case x if x < 9 && x > 5 => result.insert(0,(RomanChart.getChart(5 * index) + (RomanChart.getChart(index) * (value - 5))))
//        case 5 => result.insert(0,RomanChart.getChart(value * index))
//        case 4 => result.insert(0,(RomanChart.getChart(index) + RomanChart.getChart(5 * index)) )
//        case _ => result.insert(0,RomanChart.getChart(index) * value)
//      }
//      tmp = tmp / 10
//      index = index * 10
//    }
//    result.mkString("")
    0
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
}
