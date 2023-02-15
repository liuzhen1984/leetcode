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
    def deep(nodeList: List[TreeNode]): Unit = {
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

      var c = true
      while (c) {
        c = false
        if (list.length == 0) {
          return
        }
        if (list(list.length - 1) == null) {
          list.remove(list.length - 1)
          c = true
        }
      }

      if (max < list.length) {
        max = list.length
      }
      if (list.length > 0) {
        deep(list.toList)
      }
    }

    deep(List(root))
    max
  }

}
