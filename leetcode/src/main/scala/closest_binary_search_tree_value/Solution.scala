package closest_binary_search_tree_value
*

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
object Solution {
  def closestValue(root: TreeNode, target: Double): Int = {
    if (root == null) {
      return 0
    }
    var min = target
    if (target < root.value) {
      min = root.value - target
    } else {
      min = target - root.value
    }

    var value = root.value

    def deep(node: TreeNode, target: Double): Unit = {
      if (node == null) {
        return
      }
      if (node.value > target) {
        if (node.value - target < min) {
          min = node.value - target
          value = node.value
        }
      } else {
        if (target - node.value < min) {
          min = target - node.value
          value = node.value
        }
      }
      deep(node.left, target)
      deep(node.right, target)

    }

    deep(root, target)
    return value
  }
}
