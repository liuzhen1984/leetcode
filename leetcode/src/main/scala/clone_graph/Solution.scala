package clone_graph

import scala.collection.mutable


class Node(var _value: Int) {
  var value: Int = _value
  var neighbors: List[Node] = List()
}

object Solution {
  def cloneGraph(graph: Node): Node = {
    if (graph == null) {
      return null
    }
    if (graph.neighbors == null || graph.neighbors.size == 0) {
      return new Node(graph.value)
    }
    val map = mutable.Map[Int, Node]()

    def deep(node: Node): Unit = {

      if (node == null) {
        return
      }
      if (map.contains(node.value)) {
        return
      }
      val tmp = new Node(node.value)
      tmp.neighbors = node.neighbors
      map.put(node.value, tmp)
      for (n <- node.neighbors) {
        deep(n)
      }
    }

    deep(graph)
    for (node <- map.values) {
      //println(s"v=${node.value}, n=${node.neighbors(0).value}")
      val tmpNighbors = mutable.ListBuffer[Node]()
      for (n <- node.neighbors) {
        tmpNighbors.append(map.get(n.value).get)
      }
      node.neighbors = tmpNighbors.toList
    }
    map.get(graph.value).get
  }

}
