package lowest_common_ancestor_of_a_binary_tree_iii

import scala.collection.mutable

/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 * var value: Int = _value
 * var left: Node = null
 * var right: Node = null
 * var parent: Node = null
 * }
 */
case class Node(value: Int, left: Node, right: Node, parent: Node)

object LowestCommonAncestorOfABinaryTreeIII extends App {
  def lowestCommonAncestor(p: Node, q: Node): Node = {
    val set = mutable.Set[Node]()
    var tmp = p
    set.add(tmp)
    while (tmp.parent!=null){
      tmp = tmp.parent
      set.add(tmp)
    }
    tmp = q
    while(true){
       if(set.contains(tmp)){
         return tmp
       }else{
         tmp = tmp.parent
       }
    }
    p
  }
  def lowestCommonAncestor1(p: Node, q: Node): Node = {
    if (q.parent == null) {
      return q
    }
    if (p.parent == null) {
      return p
    }
    var tmp = p
    while (true) {
      var node = lowestCommonAncestor2(tmp, q)
      if (node != null) {
        return node
      }
      if (tmp.parent == null) {
        return p
      }
      tmp = tmp.parent
    }
    p
  }

  def lowestCommonAncestor2(p: Node, q: Node): Node = {
    if (q == null) {
       null
    } else {
      if (p.value == q.value) {
        p
      } else {
        lowestCommonAncestor2(p, q.parent)
      }
    }
  }
}
