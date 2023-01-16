package basic_calculator_ii

import scala.collection.mutable

object Solution extends App {
  println(calculate("1+3-4*6/7+2+4*4"))
  println(calculate("1+3-4*6/7"))
  println(calculate("1+10-4*6/7"))
  println(calculate("42"))
  println(calculate("0*0"))
  println(calculate("0*0"))
  println(calculate("0-2147483647"))
  println(calculate(" 3/2 "))
  println(calculate(" 3+5 / 2 "))

  def calculate(s: String): Int = {
    val addList = mutable.ListBuffer[Int]()
    var tmp = 0
    var c = ""
    var isCalculate = false;
    val len = s.trim.length
    val value = s.trim
    println(value)
    for (i <- 0 until len) {
      if (value.charAt(i) != ' ') {
        if (value.charAt(i).isDigit) {
          tmp = tmp * 10 + value.charAt(i).getNumericValue
        }
        if (i == len - 1 || !value.charAt(i).isDigit) {
          if (isCalculate) {
            if (c == "*") {
              tmp = tmp * addList(addList.length - 1)
              addList.remove(addList.length - 1)
            } else if (c == "/") {
              tmp = addList(addList.length - 1) / tmp
              addList.remove(addList.length - 1)
            } else if (c == "-") {
              tmp = tmp * -1
            }
            isCalculate = false
            c = ""
          }
          if (value.charAt(i) == '*' || value.charAt(i) == '/' || value.charAt(i) == '-') {
            c = value.charAt(i).toString
            isCalculate = true
          }
          addList.append(tmp)
          tmp = 0
        }
      }

    }
    println(addList.toString())
    addList.sum
  }
}
