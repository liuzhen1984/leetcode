package ninth.palindrome_number

object PalindromeNumber extends App {
  println(isPalindromeNumber(123))
  println(isPalindromeNumber(121))
  println(isPalindromeNumber(121121))

  def isPalindromeNumber(number: Int): Boolean = {
    if (number < 0) {
      return false
    }
    //121, 1234554321,1234321
    val strNumber = number.toString
    var start = 0
    var end = strNumber.length - 1
    while (start < end) {
      if (strNumber(start) != strNumber(end)) {
        return false
      }
      start += 1
      end -= 1
    }
    true
  }
}
