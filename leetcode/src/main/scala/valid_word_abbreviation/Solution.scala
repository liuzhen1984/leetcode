package valid_word_abbreviation

object Solution extends App {
  println(validWordAbbreviation("abcc", "a2c")==true)
  println(validWordAbbreviation("internationalization", "i12iz4n")==true)
  println(validWordAbbreviation("a", "01")==false)
  println(validWordAbbreviation("a", "2")==false)
  println(validWordAbbreviation("a", "ab")==false)
  println(validWordAbbreviation("ab", "a")==false)

  def validWordAbbreviation(word: String, abbr: String): Boolean = {
    var tmpNumr = 0
    var j = -1
    for (i <- 0 until abbr.length) {
      if (abbr(i).isDigit) {
        if(tmpNumr==0 && abbr(i).getNumericValue==0){
          return false
        }
        tmpNumr = tmpNumr * 10 + abbr(i).getNumericValue
      } else {
        j += tmpNumr + 1
        if (j >= word.length || abbr(i) != word(j)) {
          return false
        }
        tmpNumr = 0

      }
    }
    j += tmpNumr
    if(j!=word.length-1){
      return false
    }
    return true
  }

  def validWordAbbreviation2(word: String, abbr: String): Boolean = {
    var tmpNumr = 0
    var j = 0
    for (i <- 0 until abbr.length) {
      if (abbr(i).isDigit) {
        if (tmpNumr == 0 && abbr(i).getNumericValue == 0) {
          return false
        }
        println(abbr(i))
        tmpNumr = tmpNumr * 10 + abbr(i).getNumericValue
        println(tmpNumr)
      } else {
        println(s"j=$j,i=$i,tmp=$tmpNumr")
        j += tmpNumr
        if (j >= word.length || abbr(i) != word(j)) {
          return false
        }
        j += 1
        tmpNumr = 0
      }
    }
    println(s"j=$j,tmp=$tmpNumr")
    if (tmpNumr > 0) {
      if (tmpNumr == word.length - j) {
        return true
      } else {
        return false
      }
    }
    if (tmpNumr == 0 && j < word.length) {
      return false
    }
    true
  }
}
