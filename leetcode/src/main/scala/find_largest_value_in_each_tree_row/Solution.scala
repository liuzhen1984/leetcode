package find_largest_value_in_each_tree_row

import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def largestValues(root: TreeNode): List[Int] = {
    if (root == null) {
      return List()
    }
    val result = mutable.ListBuffer[Int](root.value)
    def deep(nodes: List[TreeNode]): Unit = {
      if (nodes.length == 0) {
        return
      }
      //nodes.foreach(i=>print(i.value))
      //println("")
      var max = nodes(0).value
      for (node <- nodes) {
        if(max<node.value){
          max = node.value
        }
      }
      result.append(max)
      deep(nodes.flatMap(i => List(i.left,i.right)).filter(_!=null))
    }

    deep(List(root.left,root.right).filter(_!=null))
    result.toList
  }
}
