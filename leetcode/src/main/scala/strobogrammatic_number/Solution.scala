package strobogrammatic_number

object Solution extends App {
  println(isStrobogrammatic("88"))
  println(isStrobogrammatic("69"))
  println(isStrobogrammatic("96"))
  println(isStrobogrammatic("101"))
  println(isStrobogrammatic("962"))
  println(isStrobogrammatic("1"))


  def isStrobogrammatic(num: String): Boolean = {
    val RotatedCharDigit = Map(
      '0' -> '0',
      '1' -> '1',
      '2' -> 'x',
      '3' -> 'x',
      '4' -> 'x',
      '5' -> 'x',
      '6' -> '9',
      '7' -> 'x',
      '8' -> '8',
      '9' -> '6'
    )
    num == num.reverse.map(RotatedCharDigit)
  }


  //1,2,3,4,5,6,7,8,9
  //1 0, 8, 9,6
  //1==1, 0==0, 8==8,9==6,
  def isStrobogrammatic2(num: String): Boolean = {
    if (num.size < 1) {
      return false
    }

    if (num.size == 1) {
      if (num(0) == '0'
        || num(0) == '1'
        || num(0) == '8'
      ) {
        return true
      } else {
        return false
      }
    }
    val default = Array[Char]('0', '1', '6', '8', '9')

    var left = 0
    var right = num.length - 1
    while (left <= right) {
      if (default.contains(num(left)) && default.contains(num(right))) {
        num(left) match {
          case '0' => if (num(right) != '0') {
            return false
          }
          case '1' => if (num(right) != '1') {
            return false
          }
          case '6' => if (num(right) != '9') {
            return false
          }
          case '8' => if (num(right) != '8') {
            return false
          }
          case '9' => if (num(right) != '6') {
            return false
          }
        }
      } else {
        return false
      }
      left += 1
      right -= 1
    }
    return true
  }
}
