package range_sum_of_best

case class TreeNode(value: Int = 0, left: TreeNode, right: TreeNode)

object RangeSumOfBst extends App {
  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    return sum(root, low, high, 0)
  }

  def sum(root: TreeNode, low: Int, high: Int, s: Int): Int = {

    var tmp = s
    if (root.value >= low && root.value <= high) {
      tmp = tmp + root.value
    }
    if (root.left != null) {
      tmp= sum(root.left, low, high, tmp)
    }
    if (root.right != null) {
      tmp= sum(root.right, low, high, tmp)
    }
    return tmp
  }
}
