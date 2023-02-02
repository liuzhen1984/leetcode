package diameter_of_binary

import vertical_order_traversal_of_a_binary_tree.TreeNode

case class NodePath(value:Int,left:Int,right:Int)
object Solution {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var maxLen = 0

    def nodeDeep(node:TreeNode):Int={
      if(node==null){
        return 0
      }
     var len= deep(node.right,1)
      len = len+deep(node.left,1)
      if (maxLen < len) {
        maxLen = len
      }
      nodeDeep(node.left)
      nodeDeep(node.right)
    }

    nodeDeep(root)
    maxLen
  }

  def deep(node:TreeNode,count:Int):Int={
    if(node==null){
      return count-1
    }
    val left = deep(node.left,count+1)
    val right = deep(node.right,count+1)

    if(left>right) left else  right
  }
}
