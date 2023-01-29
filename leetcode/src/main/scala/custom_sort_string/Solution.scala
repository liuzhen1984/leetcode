package custom_sort_string

object Solution extends App {
  println(customSortString2("bca","abcd"))
  println(customSortString2("cbafg","abcd"))
  println(customSortString2("fg","zaxbyhgcqisf"))
  println(customSortString2("kqep","pekeq"))
  def customSortString(order: String, s: String): String = {
    var result = ""
    var sVar = s
    for (o <- order) {
      var find = false
      while(!find){
        val index = sVar.indexOf(o.toString)
        println(s"index=$index,svar=$sVar")
        if (index >= 0) {
          result += sVar(index)
          val spValue = sVar.splitAt(index)
          sVar = spValue._1 + spValue._2.substring(1)
        }else{
          find = true
        }
      }

    }
    result += sVar.sortBy(i=>i)
    return result
  }

  //
  def customSortString2(order: String, s: String): String = {
    val ranks = order.zipWithIndex.toMap
//    s.sortWith((x, y) => (ranks.getOrElse(x, 26) < ranks.getOrElse(y, 26)))
    s.sortBy(x=>ranks.getOrElse(x,26))
  }
}
