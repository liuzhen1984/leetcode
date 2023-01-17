package cutting_ribbons

object Solution extends App {
  //  println(maxLength(Array(7, 13, 5, 6), 2))
  //  println(maxLength(Array(7, 13, 5, 6), 4))
  //  println(maxLength(Array(7, 13, 5, 6), 7))
  //  println(maxLength(Array(5, 7, 9), 22))
  //  println(maxLength(Array(9, 7, 5), 3))
  //  println(maxLength(Array(7, 5, 9), 4))
  //  println(maxLength(Array(100000, 100000, 1), 2))
  println(maxLength(Array(100000, 1, 1), 50))
  //  println(maxLength((100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,1,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000),49))


  def maxLength(ribbons: Array[Int], k: Int): Int = {

    var sum:Long = 0L
    for(r<-ribbons){
      sum = sum + r
    }
    var maxLen = sum / k
    var minLen = 1L
    var result = 0L
    while (minLen <= maxLen) {
      val mid = minLen + (maxLen - minLen) / 2
      var curently = 0L
      for (v <- ribbons) {
        curently += (v / mid)
      }
      if (curently >= k) {
        result = mid
        minLen = mid + 1
      } else {
        maxLen = mid - 1
      }

    }
    result.toInt
  }

  def maxLength2(ribbons: Array[Int], k: Int): Int = {

    val sum = ribbons.sum
    if (sum < k) {
      return 0
    }
    if (sum == k) {
      return 1
    }
    val tmp = ribbons.sortBy(i => i).reverse

    var result = 0
    var max = tmp(0)
    while (max > 0) {
      result = deep(max, tmp, k)
      //      val s = tmp.mkString(",")
      //      println(s"r=$min, result=$result,tmp=${s},k=$k")
      if (result > 0) {
        return result
      }
      max -= 1
    }
    result
  }

  def deep(r: Int, ribbons: Array[Int], k: Int): Int = {
    var i = 0
    var kTmp = k
    var tValue = 0
    while (i < ribbons.length && kTmp > 0) {
      if (tValue == 0) {
        tValue = ribbons(i)
      }
      val tmp = tValue - r
      if (tmp < r) {
        i += 1
        tValue = 0
      } else {
        tValue = tmp
      }
      if (tmp >= 0) {
        kTmp -= 1
      }
    }
    if (kTmp > 0) {
      0
    } else {
      r
    }
  }
}
