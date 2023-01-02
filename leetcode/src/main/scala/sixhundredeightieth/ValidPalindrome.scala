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
    var tmpIndex: (Int, Int) = (0, end)
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
            if (start + 1 > end || start > end - 1) {
              return false
            }
            if (!useTemp) {
              tmpIndex = (start, end)
              start += 1
              useTemp = true
            } else {
              start = tmpIndex._1
              end = tmpIndex._2 - 1
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

  def validPalindromeOnlyString(s: String): Boolean = {
    var removed = 0
    def isPalindrome(left: Int, right: Int): Boolean = {
      if (right > left) {
        if (s(left) == s(right)) {
          isPalindrome(left + 1, right - 1)
        } else {
          if (removed > 0) {
            false
          } else {
            removed += 1
            isPalindrome(left + 1, right) || isPalindrome(left, right - 1)
          }
        }
      } else {
        true
      }
    }
    isPalindrome(0, s.size - 1)
  }
}
