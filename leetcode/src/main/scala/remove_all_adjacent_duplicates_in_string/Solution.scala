package remove_all_adjacent_duplicates_in_string

object Solution extends App {
  println(removeDuplicates("abbaca"))
  println(removeDuplicates("azxxzy"))
  println(removeDuplicates("aaa"))
  println(removeDuplicates("aabbccdde"))
  println(removeDuplicates("eaabbccdd"))
  println(removeDuplicates("aaaaaaa"))

  def removeDuplicates(s: String): String = {
    def deep(s: String): String = {
      if (s.length <= 0) {
        return ""
      }
      var result = ""
      var i = 0
      var len = s.length
      var isFind = false
      while (i < len - 1) {
        if (s(i) == s(i + 1)) {
          result = s.substring(0, i) + s.substring(i + 2)
          isFind = true
          i += len
        } else {
          i += 1
        }
      }
      if(!isFind){
        return s
      }

      if (s.length == result.trim.length) {
        result.trim
      } else {
        deep(result)
      }
    }

    deep(s)
  }
}
