package interval_list_intersection

import scala.collection.mutable

object Solution {
  def intervalIntersection(firstList: Array[Array[Int]], secondList: Array[Array[Int]]): Array[Array[Int]] = {
    var i = 0
    var j = 0
    val result = mutable.ListBuffer[Array[Int]]()
    var min = -1
    var max = -1

    while (i < firstList.length && j < secondList.length) {
      max = Math.max(firstList(i)(0), secondList(j)(0))
      min = Math.min(firstList(i)(1), secondList(j)(1))
      if (max <= min) {
        result.append(Array(max, min))
      }

      if (firstList(i)(1) < secondList(j)(1)) {
        i += 1
      } else {
        j += 1
      }
    }

    result.toArray
  }
}
