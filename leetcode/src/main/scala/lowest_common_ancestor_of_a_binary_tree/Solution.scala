package lowest_common_ancestor_of_a_binary_tree

import range_sum_of_best.TreeNode
import scala.collection.mutable

object Solution {

  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    var result: TreeNode = null

    def deepNode(root: TreeNode): Int = {
      if (root == null) {
        return 0
      }
      var left = deepNode(root.left)
      var right = deepNode(root.right)
      var self = 0
      if (root.value == p.value || root.value == q.value) {
        self = 1
      }
      if ((left + right + self) == 2) {
        result = root
      }
      if (left == 1 || right == 1 || self == 1) {
        return 1
      }
      return 0
    }

    deepNode(root)
    return result
  }


  def lowestCommonAncestor2(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    var listp = mutable.ListBuffer[TreeNode]()
    deepNode2(root, p, listp)
    var listq = mutable.ListBuffer[TreeNode]()
    deepNode2(root, q, listq)

    listp.map(_.value).foreach(print)
    println("")
    listq.map(_.value).foreach(print)

    var result = root
    for (i <- 0 until listp.length) {
      if (i >= listq.length) {
        return result
      }
      if (listp(i) != listq(i)) {
        return result
      }
      result = listp(i)
    }
    return result
  }

  def deepNode2(root: TreeNode, find: TreeNode, list: mutable.ListBuffer[TreeNode]): Boolean = {
    list.append(root)
    if (root.value == find.value) {
      return true
    }
    var result = false
    if (root.left != null) {
      result = deepNode(root.left, find, list)
    }
    if (!result && root.right != null) {
      result = deepNode(root.right, find, list)
    }
    if (!result) {
      list.remove(list.length - 1)
    }
    result
  }

}
