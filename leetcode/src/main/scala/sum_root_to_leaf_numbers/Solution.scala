package sum_root_to_leaf_numbers

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def sumNumbers(root: TreeNode): Int = {
    var result = 0

    def deep(node: TreeNode, value: Int): Unit = {

      if (node == null) {
        return
      }
      var tmp = value * 10 + node.value
      if (node.left == null && node.right == null) {
        result = result + tmp
        // println(s"result=$result, value=$value,tmp=$tmp")
        return
      }

      if (node.left != null) {
        deep(node.left, tmp)
      }
      if (node.right != null) {
        deep(node.right, tmp)
      }
    }

    deep(root, result)
    result
  }
}
