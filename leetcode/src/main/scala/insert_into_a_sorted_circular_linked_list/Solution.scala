package insert_into_a_sorted_circular_linked_list

class Node(var _value: Int) {
  var value: Int = _value
  var next: Node = null
}

object Solution {
  def insertToNode(node:Node,value:Int):Unit={
    val tmp = new Node(value)
    tmp.next = node.next
    node.next = tmp
  }
  def insert(head: Node, insertVal: Int): Node = {
    def deep(node: Node, insertValue: Int, first: Boolean = false): Unit = {
      if (node == null) {
        return
      }
      if (node == head && !first) {
        return
      }
      if (node == node.next) {
        insertToNode(node,insertValue)
        return
      }
      //    println(s"${node.value} , $insertValue")
      if (node.value > node.next.value) {
        if (insertValue > node.next.value && insertValue < node.value) {
          deep(node.next, insertValue)
        } else {
          insertToNode(node,insertValue)
        }
      } else {
        if ((node.value == node.next.value && node.next == head) || (node.value < insertValue && node.next.value >= insertValue)) {
          insertToNode(node,insertValue)
        } else {
          deep(node.next, insertValue)
        }
      }
    }

    if (head == null) {
      val tmp = new Node(insertVal)
      tmp.next = tmp
      return tmp
    }
    deep(head, insertVal, true)
    head
  }
}
