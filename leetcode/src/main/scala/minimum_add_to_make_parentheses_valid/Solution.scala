package minimum_add_to_make_parentheses_valid

import scala.collection.mutable

object Solution extends App {
  println(minAddToMakeValid("())"))
  println(minAddToMakeValid("((("))
  println(minAddToMakeValid("()"))
  println(minAddToMakeValid("(()))(("))

  def minAddToMakeValid(s: String): Int = {
    var left = 0
    var right = 0
    for (i <- s) {
      if (i == '(') {
        left += 1
      }
      if (i == ')') {
        if (left <= 0) {
          right += 1
        } else {
          left -= 1
        }
      }
    }
    right + left
  }

  def minAddToMakeValid2(s: String): Int = {
    var list = mutable.ListBuffer[Char]()
    for (i <- s) {
      if (i == '(') {
        list.append(i)
      }
      if (i == ')') {
        if (list.size > 0 && list(list.length - 1) == '(') {
          list.remove(list.length - 1)
        } else {
          list.append(')')
        }
      }
    }
    list.size
  }
}
