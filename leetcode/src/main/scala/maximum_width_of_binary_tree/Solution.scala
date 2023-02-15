package maximum_width_of_binary_tree

import scala.collection.mutable


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def widthOfBinaryTree(root: TreeNode): Int = {
    var max = 0
    if (root != null) {
      max = 1
    }
    var result = deep(List(root))
    if (max < result.length) {
      max = result.length
    }
    while (result.length > 0) {
      result = deep(result)
      if (max < result.length) {
        max = result.length
      }
    }
    max
  }

  def deep(nodeList: List[TreeNode]): List[TreeNode] = {
    val list = mutable.ListBuffer[TreeNode]()
    for (node <- nodeList) {
      if (node != null) {
        list.append(node.left, node.right)
      } else {
        list.append(null, null)
      }
      if (list(0) == null) {
        list.remove(0)
        if (list(0) == null) {
          list.remove(0)
        }
      }
    }
    while (list.length > 0 && list(list.length - 1) == null) {
      list.remove(list.length - 1)
    }

    list.toList
  }

}
