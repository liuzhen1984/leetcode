package valid_word_abbreviation

object Solution extends App {
  println(validWordAbbreviation("abcc", "a2c"))
  println(validWordAbbreviation("internationalization", "i12iz4n"))
  println(validWordAbbreviation("a", "01"))
  println(validWordAbbreviation("a", "2"))
  println(validWordAbbreviation("a", "ab"))
  println(validWordAbbreviation("ab", "a"))

  def validWordAbbreviation(word: String, abbr: String): Boolean = {
    var tmpNumr = 0
    var j = 0
    for (i <- 0 until abbr.length) {
      if (abbr(i).isDigit) {
        if(tmpNumr==0 && abbr(i).getNumericValue==0){
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
    if(tmpNumr>0){
      if(tmpNumr == word.length - j){
        return true
      }else{
        return false
      }
    }
    if (tmpNumr == 0 && j < word.length) {
      return false
    }
    true
  }
}
