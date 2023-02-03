package continuous_subarray_sum

import scala.collection.mutable

object Solution extends App {
  //  println(checkSubarraySum(Array(1, 0, 1), 2))
  //  println(checkSubarraySum(Array(23, 2, 2, 6, 2, 5), 6))
  //  println(checkSubarraySum(Array(23, 2, 6, 2, 5), 6))
  println(checkSubarraySum(Array(1, 2, 3), 5))
  println(checkSubarraySum(Array(1, 3, 0, 6), 6))
  println(checkSubarraySum(Array(1, 0, 1, 0, 1), 4))
  println(checkSubarraySum(Array(1, 0), 2))

  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    var total = 0
    val sumIndex = mutable.Map[Int, Int]()
    for (i <- 0 until nums.length) {
      total = total + nums(i)
      var mod = total % k
      if (mod == 0 & i > 0) {
        return true
      }
      if (sumIndex.contains(mod) && i - sumIndex(mod) > 1) {
        return true
      }
      if (!sumIndex.contains(mod)) {
        sumIndex.put(mod,i)
      }
    }
    return false

  }

  def checkSubarraySum2(nums: Array[Int], k: Int): Boolean = {
    if (nums.mkString("-", "-", "-").contains("-0-0-")) {
      return true
    }
    deep(nums, k)

  }

  def deep(nums: Array[Int], k: Int): Boolean = {
    if (nums.length < 2) {
      return false
    }
    var sum = -1
    for (num <- nums) {
      if (sum < 0) {
        sum = num
      } else {
        sum += num
        if (sum % k == 0) {
          return true
        }
      }
      //      println(s"sum=$sum")
    }

    //    nums.slice(1, nums.length).foreach(print)
    //    println(" ")
    deep(nums.slice(1, nums.length), k)
  }
}
