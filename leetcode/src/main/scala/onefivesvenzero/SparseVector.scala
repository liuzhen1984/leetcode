package onefivesvenzero

class SparseVector(nums: Array[Int]) {
  // Return the dotProduct of two sparse vectors
  def getNums(): Array[Int] ={
    nums
  }
  def dotProduct(vec: SparseVector): Int = {
    var reuslt = 0
    for (i <- 0 until  this.nums.length) {
      if(this.nums(i)>0 && vec.getNums()(i)>0){
        reuslt = reuslt + this.nums(i) * vec.getNums()(i)
      }
    }
    reuslt
  }
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * var v1 = new SparseVector(nums1)
 * var v2 = new SparseVector(nums2)
 * val ans = v1.dotProduct(v2)
 */

object SparseVector extends App {
  var v1 = new SparseVector(Array(1,0,0,2,3))
  var v2 = new SparseVector(Array(0,3,0,4,0))
  val ans = v1.dotProduct(v2)
  println(ans)
}
