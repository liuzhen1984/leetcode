package exclusive_time_of_functions

import scala.collection.mutable

object Solution extends App {
  //  println(exclusiveTime(1, List[String]("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")).toList)
  //  println(exclusiveTime(2, List[String]("0:start:0", "1:start:2", "1:end:5", "0:end:6")).toList)
  //  println(exclusiveTime(2, List[String]("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")).toList)
  //  println(exclusiveTime(2, List[String]("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")).toList)
  println(exclusiveTime(9, List[String]("0:start:0", "1:start:4", "2:start:8", "3:start:12", "4:start:17", "5:start:18", "6:start:20", "7:start:21", "8:start:23",  "8:end:701", "7:end:705", "6:end:709", "5:end:710", "4:end:711", "3:end:714", "2:end:718", "86:start:722", "24:start:723", "24:end:726", "18:start:728", "63:start:733", "63:end:736", "18:end:738", "86:end:742", "1:end:747", "0:end:749")).toList)
  //

  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val map = mutable.Map[String, Int]()
    val stack = mutable.ListBuffer[(Int,String,Int)]()
    for (log <- logs) {
      val larr = log.split(":")
      if (larr(1) == "start") {
        stack.append((larr(0).toInt,larr(1),larr(2).toInt))
      } else {
        var label = true
        var index = 0
        while (label) {
          index += 1
          val tmp = stack(stack.length - index)
          if (tmp._2 == "start") {
            label = false
          } else {
            larr(2) = (larr(2).toInt - tmp._3).toString
          }
        }
        val tmp = stack(stack.length - index)
        larr(1) = "fill"
        larr(2) = (larr(2).toInt - tmp._3 + 1).toString
        stack(stack.length - index) = (larr(0).toInt,larr(1),larr(2).toInt)
      }
    }
    stack.groupBy(_._1).toList.sortBy(_._1).map(i => i._2.map(_._3).sum).toArray
  }
}
