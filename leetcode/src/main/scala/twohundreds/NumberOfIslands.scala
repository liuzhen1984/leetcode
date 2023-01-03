package twohundreds

/*
 */
object NumberOfIslands extends App {
  println(numIslands(Array(
    Array('1', '0', '0', '1', '1', '1', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
    Array('1', '0', '0', '1', '1', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0'),
    Array('0', '0', '0', '1', '1', '1', '1', '0', '1', '0', '1', '1', '0', '0', '0', '0', '1', '0', '1', '0'),
    Array('0', '0', '0', '1', '1', '0', '0', '1', '0', '0', '0', '1', '1', '1', '0', '0', '1', '0', '0', '1'),
    Array('0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
    Array('1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0', '0', '0', '0', '0', '0', '1', '0', '1'),
    Array('0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'),
    Array('0', '0', '0', '1', '0', '1', '0', '0', '1', '1', '0', '1', '0', '1', '1', '0', '1', '1', '1', '0'),
    Array('0', '0', '0', '0', '1', '0', '0', '1', '1', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1'),
    Array('0', '0', '1', '0', '0', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '0', '1', '0'),
    Array('1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0'),
    Array('0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0', '1', '1', '1', '0', '1', '1', '0', '0'),
    Array('1', '1', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1'),
    Array('0', '1', '0', '0', '1', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '0', '1', '0', '0', '0'),
    Array('0', '0', '1', '1', '1', '0', '0', '0', '1', '1', '0', '0', '0', '1', '0', '1', '0', '0', '0', '0'),
    Array('1', '0', '0', '1', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1'),
    Array('1', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1', '0', '0', '0', '0'),
    Array('0', '1', '1', '0', '0', '0', '1', '1', '1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '0'),
    Array('0', '1', '0', '0', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0', '1', '0', '0', '1', '1'),
    Array('0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '0', '1', '0', '0', '0', '1', '1', '0', '0', '0')

  )))


  def numIslands(grid: Array[Array[Char]]): Int = {

    var count = 0

    for (i <- grid.indices) {
      for (j <- grid.head.indices) {

        if (grid(i)(j) == '1') {
          count += 1

          islandBfs(grid, i, j)
        }
      }
    }

    count
  }

  private def islandBfs(grid: Array[Array[Char]], i: Int, j: Int): Unit = {

    if (i < 0 || i >= grid.length || j < 0 || j >= grid.head.length || grid(i)(j) == '0') {
      return
    }

    grid(i)(j) = '0'

    islandBfs(grid, i + 1, j) //up
    islandBfs(grid, i - 1, j) //down
    islandBfs(grid, i, j + 1) //left
    islandBfs(grid, i, j - 1) //right
  }

  /**
   *
   * def numIslands(arr: Array[Array[Char]]): Int = {
   * var count = 0
   * val label = mutable.Map[String, Boolean]()
   * var result = true
   *
   * def discoveryIsLand(x: Int, y: Int): Unit = {
   * if (label.contains(toString(x) + toString(y)) && label.get(toString(x) + toString(y)).get) {
   * result = false
   * } else {
   * label.put(toString(x) + toString(y), false)
   * if (y < arr(x).length - 1 && arr(x)(y + 1) == '1') {
   * discoveryIsLand(x, y + 1)
   * }
   * if (x < arr.length - 1 && arr(x + 1)(y) == '1') {
   * discoveryIsLand(x + 1, y)
   * }
   * }
   *
   * }
   *
   * for (i <- 0 until arr.length) {
   * for (j <- 0 until arr(i).length) {
   * if (arr(i)(j) == '1' && !label.contains(toString(i) + toString(j))) {
   * discoveryIsLand(i, j)
   * if (result) {
   * count += 1
   * }
   * for(key<-label.keys){
   * label.put(key,true)
   * }
   * }
   * result = true
   * }
   * }
   * count
   * }
   *
   *
   * def toString(num: Int): String = {
   * if(num<10){
   * return s"00$num"
   * }
   * if(num<100){
   * return s"0$num"
   * }
   * return num.toString
   *
   * }
   * */

}
