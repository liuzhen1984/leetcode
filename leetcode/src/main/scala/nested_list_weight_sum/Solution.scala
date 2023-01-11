package nested_list_weight_sum

trait NestedInteger {
  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean

  // Return the single integer that this NestedInteger holds, if it holds a single integer.
  def getInteger: Int

  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int): Unit

  // Return the nested list that this NestedInteger holds, if it holds a nested list.
  def getList: Array[NestedInteger]

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger): Unit
}

object Solution {
  def depthSum(nestedList: List[NestedInteger]): Int = {
    var total = 0
    for (nest <- nestedList) {
      total += depth(nest, 1)
    }
    return total
  }

  def depth(nestedInteger: NestedInteger, dep: Int): Int = {
    if (nestedInteger.isInteger) {
      return nestedInteger.getInteger * dep
    } else {
      var total = 0
      for (nest <- nestedInteger.getList) {
        total += depth(nest, dep + 1)
      }
      return total
    }
  }

}
