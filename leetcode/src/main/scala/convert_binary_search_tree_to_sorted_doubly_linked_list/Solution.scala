package convert_binary_search_tree_to_sorted_doubly_linked_list

class Node(var _value: Int) {
  var value: Int = _value
  var left: Node = null
  var right: Node = null
}

object Solution {
  //[4,2,5,1,3]
  def treeToDoublyList(root: Node): Node = {
    //define a doubly linked list
    if(root==null){
      return null
    }
    var result = new Node(root.value)
    result.left = result
    result.right = result
    def loopTreee( leaf: Node): Node = {
      if (leaf == null) {
        return result
      }
      result = deep(result, result, leaf)
      result = loopTreee(leaf.left)
      result = loopTreee(leaf.right)
      result
    }
    result= loopTreee(root.left)
    result = loopTreee(root.right)
    return result
  }



  def deep( rootValue:Node,result: Node, node: Node): Node = {
    if (node == null) {
      return result
    }
    println(s"${node.value},result=${result.value}=${result.right.value}=${result.left.value},rootValue=${rootValue.value}")
    if (result.value > node.value) {
      var tmpNode = new Node(node.value)
      tmpNode.right = result
      tmpNode.left = result.left
      result.left = tmpNode
      tmpNode.left.right = tmpNode
      if(tmpNode.right.value==rootValue.value){
        return tmpNode
      }
      return rootValue
    } else {
      if (result.right.value != rootValue.value) {
        return deep(rootValue, result.right, node)
      } else {
        val tmpNode = new Node(node.value)
        tmpNode.right = result.right
        tmpNode.left = result
        result.right = tmpNode
        tmpNode.right.left=tmpNode
        return tmpNode.right
      }
    }
  }

}
