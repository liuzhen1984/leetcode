package remove_invalid_parentheses

import scala.collection.mutable

object Solution extends App {
//    println(removeInvalidParentheses("()())()"))
//    println(removeInvalidParentheses("(a)())()"))
//    println(removeInvalidParentheses("n"))
//    println(removeInvalidParentheses("x(((("))
//    println(removeInvalidParentheses(")("))
//    println(removeInvalidParentheses("()"))
//    println(removeInvalidParentheses("(()"))
//    println(removeInvalidParentheses("((i)"))
  println(removeInvalidParentheses("(((k()(("))

  def removeInvalidParentheses(s: String): List[String] = {
    val rsList = mutable.Set[String]()
    var result = ""
    var totalSize = 0
    result = deep(s, result, 0)
    //    if (result != null && rsList.size == 0) {
    //      rsList.add(result)
    //    }

    //split two way left and right
    def deep(s: String, res: String, c: Int): String = {
      var result = res
      var count = c
      for (i <- 0 until s.length) {
        if (s(i) == '(') {
          val r = deep(s.splitAt(i+1)._2, result, count)
          if (r != null) {
            rsList.add(r)
          }
          result = result + s(i).toString
          count += 1
        }
        else if (s(i) == ')') {
          if (count > 0) {
            val r = deep(s.splitAt(i + 1)._2, result, count)
            if (r != null) {
              rsList.add(r)
            }
            count -= 1
            result = result + s(i).toString
          }
        } else {
          result = result + s(i).toString
        }
      }

      if (count == 0) {
        totalSize = result.length
      }
      rsList.add(result)
//      println(result)

      result
    }

    println(rsList)

    //remove invalid str and remove duplicate
    var maxLen = 0
    val resultList = rsList.filter(i => (i.length >= totalSize || totalSize == 0)).map(s => {
      var count = 0
      var str = ""
      for (i <- s.length - 1 to 0 by -1) {
        if (s(i) == ')') {
          str = s(i).toString + str
          count += 1
        }
        else if (s(i) == '(') {
          if (count > 0) {
            str = s(i).toString + str
            count -= 1
          }
        }
        else {
          str = s(i).toString + str
        }
      }
      if (maxLen < str.length) {
        maxLen = str.length
      }
      str
    }).filter(i => i != "" && i.length >= maxLen).toList

    if (resultList.size == 0) {
      return List[String]("")
    }
    resultList
  }

//  def isValid(s:String):Boolean={
//
//  }

}
