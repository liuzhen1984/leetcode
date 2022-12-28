package eighth.string_to_int_atoi

object StringToIntAtoi extends App {

  println(stringToInteger("-91283472332"))
  println(stringToInteger("window3"))
  println(stringToInteger("3wind"))

  def stringToInteger(value: String): Integer = {
    val tmp = new StringBuffer()
    var start = false
    for (v <- value.trim) {
      if (!start) {
        start = true;
        if (v == '+' || v == '-') {
          tmp.append(v.toString)
          tmp.append(0)
        }else{
          if (v >= '0' && v <= '9') {
            tmp.append(v.toString)
          } else {
            return 0
          }
        }
      }else{
        if (v >= '0' && v <= '9') {
          tmp.append(v.toString)
        } else {
          return getInt(tmp.toString.toLong)
        }
      }

    }
    getInt(tmp.toString.toLong)
  }

  private def getInt(value: Long): Int = {

    if (value <= -2147483648L) {
      return -2147483648
    }
    if (value >= 2147483647L) {
      return 2147483647
    }

    return value.toInt
  }

}
