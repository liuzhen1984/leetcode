package ninehundredeightyseventh

import scala.collection.mutable
import scala.collection.mutable._

object VerticalOrderTraversalOfBinary extends App {
  //使用一个可变二位list，通过，y值从小到达排列，相同的放在相同的list中

  println(solution(Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)))
  println(solution(Array[Int](1, 2, 3, 4, 5, 6, 7)))

  case class Node(value: Int, left: Int, right: Int, isLeft: Boolean)

  case class TreeNode(value:Int=0,left:TreeNode=_,right:TreeNode=_)
  def verticalTraversal(root: TreeNode): List[List[Int]] = {
    val map = mutable.Map[Int, ListBuffer[(Int,Int)]]()

    def trans(node:TreeNode,leftValue:Int,rightValue:Int):Unit={
      if(node==null){
        return
      }
      if(map.contains(rightValue)){
        map.get(rightValue).get.append((leftValue,node.value))
      }else{
        map.put(rightValue,ListBuffer((leftValue,node.value)))
      }
      if(node.right!=null){
        trans(node.right,leftValue+1,rightValue+1)
      }
      if(node.left!=null){
        trans(node.left,leftValue+1,rightValue-1)
      }
    }
    trans(root,0,0)
    val resultTuple: ListBuffer[List[Int]] = ListBuffer()
    for(k <-map.keys.toList.sortBy(a=>a)) {
      resultTuple.append(map.get(k).get.toList.sortBy(a => (a._1,a._2)).map(_._2))
    }
      resultTuple.toList
  }

  def solution(numbers: Array[Int]): List[List[Int]] = {
    val resultTuple: ListBuffer[List[Int]] = ListBuffer()
    val map = mutable.Map[Int, ListBuffer[Node]]()
    var i = 0
    var layer = 0
    val leafCount = 2
    while (i < numbers.length) {
      println(s"i=$i")
      if (layer == 0) {
        map.put(layer, ListBuffer(Node(numbers(i), layer, layer, false)))
        i += 1
      }
      if (map.contains(layer - 1)) {
        for (node <- map.get(layer - 1).get) {
          if (i < numbers.length - 1) {
            if (map.contains(layer)) {
              map.get(layer).get.append(Node(numbers(i), layer, node.right - 1, true))
              map.get(layer).get.append(Node(numbers(i + 1), layer, node.right + 1, false))
            } else {
              map.put(layer, ListBuffer(Node(numbers(i), layer, node.right - 1, true), Node(numbers(i + 1), layer, node.right + 1, false)))
            }
            i += leafCount
          } else {
            i += leafCount
          }
        }
      }
      layer += 1

    }

    val mapResult = map.flatMap(_._2).groupBy(_.right)

    for(i<- layer * -1 to layer){
      if(mapResult.contains(i)){
        resultTuple.append(mapResult(i).map(_.value).toList.sortBy(a=>a))
      }
    }
    resultTuple.toList
  }
}
