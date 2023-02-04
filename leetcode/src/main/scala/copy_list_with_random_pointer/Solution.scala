package copy_list_with_random_pointer

import scala.collection.mutable


class Node(var _value: Int) {
  var value: Int = _value
  var next: Node = null
  var random: Node = null
}

object Solution {
  //Input
  //[[3,null],[5,17],[4,null],[-9,6],[-10,3],[5,15],[0,11],[6,null],[-6,16],[3,16],[-6,11],[9,12],[-2,1],[-3,11],[-1,10],[2,11],[-3,null],[-9,7],[-2,4],[-8,null],[5,null]]
  def copyRandomList(head: Node): Node = {
    val map = mutable.Map[Node, Node]()

    def generate(node: Node): Node = {
      if (node == null) {
        return null
      }
      if (map.contains(node)) {
        return map.get(node).get
      }
      val result = new Node(node.value)
      result.next = generate(node.next)
      if (node.random != null) {
        result.random = node.random
      }
      map.put(node, result)
      result
    }

    def fillInRandom(node: Node): Unit = {
      if (node != null && node.random != null) {
        node.random = map.get(node.random).getOrElse(null)
      }
    }

    var result = generate(head)
    var tmp = result
    while (tmp != null) {
      fillInRandom(tmp)
      tmp = tmp.next
    }
    result
  }

}
