package group_shifted_strings

import scala.collection.mutable

//Group-Shifted-Strings
object Solution extends App {
  //  println(groupStrings(Array("abc","bcd","a","z")))
  //  println(groupStrings(Array("abc","bcd","acef","xyz","az","ba","a","z","abc")))
  //  println(groupStrings(Array("a")))
  //  println(groupStrings(Array("abc", "bce", "acef", "xyz", "cz", "da", "a", "z")))
  println(groupStrings(Array("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "al")))

  def groupStrings(strings: Array[String]): List[List[String]] = {
    val tmpMap = mutable.Map[String, mutable.ListBuffer[String]]()
    for (str <- strings) {
      var key = ""
      if (str.length == 1) {
        key = "non"
      } else {
        for (i <- 1 until str.length) {
          var v = str(i).toInt - str(i - 1).toInt
          if (v < 0) {
            v = 26 + v
          }
          key = key + "-" + (v).toString
        }
      }
      //      println(s"key=$key,str=$str")

      if (!tmpMap.contains(key)) {
        tmpMap.put(key, mutable.ListBuffer[String]())
      }
      tmpMap.get(key).getOrElse(mutable.ListBuffer[String]()).append(str)

    }
    tmpMap.values.map(_.toList).toList
  }
}
