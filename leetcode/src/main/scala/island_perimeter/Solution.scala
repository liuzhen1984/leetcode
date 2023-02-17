package island_perimeter

import scala.collection.mutable

object Solution {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {

    val m = grid.length
    val n = grid(0).length
    var perimeter = 0
    // Iteration
    for (row <- 0 until m) {
      for (col <- 0 until n) {
        if (grid(row)(col) == 1) {
          perimeter += 4
          if (row > 0 && grid(row - 1)(col) == 1) perimeter -= 2
          if (col > 0 && grid(row)(col - 1) == 1) perimeter -= 2
        }
      }
    }
    return perimeter
  }

  //每个格式4， 每相邻一个就减1， 最后获取总数，然后减去各个相邻的总数即可
  def islandPerimeter2(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0) {
      return 0
    }
    if (grid(0).length == 0) {
      return 0
    }
    if (grid.length == 1 && grid(0).length == 1) {
      if (grid(0)(0) == 1) {
        return 4
      } else {
        return 0
      }
    }

    val map = mutable.Map[String, Int]()

    def deep(x: Int, y: Int): Int = {
      if (map.contains(x + "-" + y)) return 0
      if (grid(x)(y) == 0) return 0
      var result = 0
      if (x < grid.length - 1 && grid(x + 1)(y) == 1) {
        result += 1
      }
      if (y < grid(x).length - 1 && grid(x)(y + 1) == 1) {
        result += 1
      }
      if (x > 0) {
        if (grid(x - 1)(y) == 1) {
          result += 1
        }
      }
      if (y > 0) {
        if (grid(x)(y - 1) == 1) {
          result += 1
        }
      }
      map.put(x + "-" + y, result)
      result

    }

    var x = 0
    var y = 0
    for (x <- 0 until grid.length) {
      for (y <- 0 until grid(x).length) {
        deep(x, y)
      }
    }
    val total = map.size * 4
    total - map.values.sum
  }

}
