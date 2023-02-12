package capacity_to_ship_packages_within_d_days

object Solution extends App {
//  println(shipWithinDays(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5))
//  println(shipWithinDays(Array(1,2,3,1,1), 4))
//  println(shipWithinDays(Array(3,2,2,4,1,4), 3))
 // println(shipWithinDays(Array(361,321,186,186,67,283,36,471,304,218,60,78,149,166,282,384,61,242,426,275,236,221,27,261,487,90,468,19,453,241), 15))
  println(shipWithinDays(Array(337,399,204,451,273,471,37,211,67,224,126,123,294,295,498,69,264,307,419,232,361,301,116,216,227,203,456,195,444,302,58,496,84,280,58,107,300,334,418,241), 20))

  def shipWithinDays(weights: Array[Int], days: Int): Int = {
    var start = weights.sum / days
    println(s"start=$start")
    if (start < 1) {
      return 0
    }
    if (start <= weights.max) {
      start= weights.max
    }
    if (weights.length == start) {
      return 1
    }

    def deep(start: Int, weights: Array[Int]): Int = {
      var tmp = start
      var result = 0
      var i = 0
      while (i < weights.length) {
        tmp -= weights(i)
        if (tmp < 0) {
          result += 1
          tmp = start
        } else {
          i += 1
        }
        if (i >= weights.length && tmp >= 0) {
          result += 1
        }
        println(s"i=$i,tmp=$tmp,result=$result")
      }

      if (result > days) {
        deep(start + 1, weights)
      } else {
        start
      }
    }

    deep(start, weights)

  }
}
