package shortest_path_in_binary_matrix

import scala.collection.mutable

object Solution extends App {
//  println(shortestPathBinaryMatrix(Array(Array(0, 0, 0), Array(0, 1, 0), Array(1, 1, 0))))
//  //[[0,1,1,0,0,0],[0,1,0,1,1,0],[0,1,1,0,1,0],[0,0,0,1,1,0],[1,1,1,1,1,0],[1,1,1,1,1,0]]
//  println(shortestPathBinaryMatrix(Array(
//    Array(0, 1, 1, 0, 0, 0),
//    Array(0, 1, 0, 1, 1, 0),
//    Array(0, 1, 1, 0, 1, 0),
//    Array(0, 0, 0, 1, 1, 0),
//    Array(1, 1, 1, 1, 1, 0),
//    Array(1, 1, 1, 1, 1, 0),
//  )))
  //[[0,0,0,0,1],[1,0,0,0,0],[0,1,0,1,0],[0,0,0,1,1],[0,0,0,1,0]]
  println(shortestPathBinaryMatrix(Array(
    Array(0, 0, 0, 0, 1),
    Array(1, 0, 0, 0, 0),
    Array(0, 1, 0, 1, 0),
    Array(0, 0, 0, 1, 1),
    Array(0, 0, 0, 1, 0),
  )))

  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    val minLen = grid.length
    var i = 0
    var j = 0
    if (grid(i)(j) != 0 || grid(minLen - 1)(minLen - 1) != 0) {
      return -1
    }
    var resultList = mutable.ListBuffer[String]()
    var tmp = mutable.ListBuffer[String]()
    tmp.append(i + "-" + j)

    var end = false;
    while (!end) {
      end = true
      val len = tmp.length
      for (i <- 0 until len) {
        val allArray = tmp(i).split("_")
        val tArray = allArray(allArray.length - 1).split("-")
        var result = bfs(tArray(0).toInt + 1, tArray(1).toInt + 1, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false
        }
        result = bfs(tArray(0).toInt, tArray(1).toInt + 1, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
        result = bfs(tArray(0).toInt + 1, tArray(1).toInt, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
        result = bfs(tArray(0).toInt - 1, tArray(1).toInt - 1, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
        result = bfs(tArray(0).toInt - 1, tArray(1).toInt, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
        result = bfs(tArray(0).toInt, tArray(1).toInt - 1, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
        result = bfs(tArray(0).toInt + 1, tArray(1).toInt - 1, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
        result = bfs(tArray(0).toInt - 1, tArray(1).toInt + 1, minLen, grid, tmp(i))
        if (result != "") {
          tmp.append(tmp(i) + "_" + result)
          end = false

        }
      }
      println(tmp)
      for (t <- tmp) {
        if (t.contains(minLen - 1 + "-" + (minLen - 1))) {
          if(t.split("_").length==minLen){
            return minLen
          }
          resultList.append(t)
        }
      }
      if (!end) {
        tmp.remove(0, len)
        println(tmp)
      }
    }

    if (resultList.size <= 0) {
      return -1
    }
    println(s"result=$resultList")
    return resultList.map(i => i.split("_").size).sortBy(i => i).toList(0)

  }

  def bfs(x: Int, y: Int, minLen: Int, grid: Array[Array[Int]], tmp: String): String = {
    if (x < 0 || y < 0 || x >= minLen || y >= minLen) {
      return ""
    }
    if (tmp.contains(x.toString + "-" + y.toString)) {
      return ""
    }
//        println(s"x=$x,y=$y,graid=${grid(x)(y)}")
    if (grid(x)(y) == 0) {
      return x.toString + "-" + y.toString
    } else {
      return ""
    }
  }
}
