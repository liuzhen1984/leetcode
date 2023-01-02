package sixhundredeightieth

object ValidPalindrome extends App {
  println(isPalindrome("abccde"))
  println(isPalindrome("0"))
  println(isPalindrome("0p"))
  println(isPalindrome("race a car"))
  println(isPalindrome("A man, a plan, a canal: Panama"))
  println(isPalindrome("A man, a plan, a canl: Panma"))

  def isPalindrome(str: String): Boolean = {
    var start = 0
    var end = str.length - 1
    while (start < end) {
      if (!isChar(str(start))) {
        start += 1
      } else {
        if (!isChar(str(end))) {
          end -= 1
        } else {
          if (str(start).toLower != str(end).toLower) {
            return false
          } else {
            start += 1
            end -= 1
          }
        }
      }
    }
    true
  }

  def isChar(c: Char): Boolean = {
    (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
  }

  def validPalindrome(str: String): Boolean = {
    var start = 0
    var end = str.length - 1
    var tmpIndex:(Int,Int)=(0,end)
    var useTemp = false
    var isEnd = false
    while (start < end) {
      if (!isChar(str(start))) {
        start += 1
      } else {
        if (!isChar(str(end))) {
          end -= 1
        } else {
          if (str(start).toLower != str(end).toLower) {
            if (isEnd) {
              return false
            }
            if(start+1>end || start>end-1){
              return false
            }
            if(!useTemp){
              tmpIndex = (start, end)
              start += 1
              useTemp=true
            }else{
              start = tmpIndex._1
              end = tmpIndex._2-1
              isEnd = true
            }

          } else {
            start += 1
            end -= 1
          }
        }
      }
    }
    true
  }
}
