package subarray_sum_equals_k

import scala.collection.mutable

object Solution extends App {
  println(subarraySum(Array[Int](1, 1, 1), 2))
  println(subarraySum2(Array[Int](1, 1, 1), 2))
  println(subarraySum(Array[Int](1, -1, 0), 0))
  println(subarraySum2(Array[Int](1, -1, 0), 0))
  println(subarraySum2(Array[Int](100,1,2,3,4), 3))
  println(subarraySum(Array[Int](100,1,2,3,4), 3))

  def subarraySum(nums: Array[Int], k: Int): Int = {
    var arrayNumber = 0
    var pre = 0
    val map = mutable.Map[Int, Int]()
    map.put(0, 1)
    for (i <- 0 until nums.length) {
      pre += nums(i)
      if (map.get(pre - k).getOrElse(0) > 0) {
        arrayNumber += map.get(pre - k).getOrElse(1)
      }
      map.put(pre, map.get(pre).getOrElse(0) + 1)
    }
    arrayNumber
  }

  def subarraySum2(nums: Array[Int], k: Int): Int = {
    var arrayNumber = 0
    for (i <- 0 until nums.length) {
      var j = i + 1
      var kTmp = k - nums(i)
      if(kTmp==0){
        arrayNumber += 1
      }else{
        if (j < nums.length) {
          while (j < nums.length) {
            kTmp = kTmp - nums(j)
            if (kTmp == 0) {
              arrayNumber += 1
            }
            j += 1
          }
        } else {
          if (kTmp == 0) {
            arrayNumber += 1
          }
        }
      }


    }
    arrayNumber
  }


}
