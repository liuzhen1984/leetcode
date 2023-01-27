package binary_tree_right_side_view

import vertical_order_traversal_of_a_binary_tree.TreeNode

object Solution {
  def rightSideView(root: TreeNode): List[Int] = {
    def flattenTree(nodes: List[TreeNode], acc: List[Int]): List[Int] = {
      val tmp = nodes.flatMap(i => List(i.left, i.right)).filter(_ != null)
      if (!tmp.isEmpty) {
        acc
      } else {
        flattenTree(tmp, acc :+ tmp.last.value)
      }
    }

    if (root == null) {
      Nil
    } else {
      flattenTree(List(root), List(root.value))
    }

  }
}
