package kth_largest_element_in_an_array
object Solution {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    nums.sortBy(i=>i).reverse(k-1)
  }
}
