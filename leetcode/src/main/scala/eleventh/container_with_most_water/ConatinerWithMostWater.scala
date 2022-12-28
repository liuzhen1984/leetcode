package eleventh.container_with_most_water

object ConatinerWithMostWater extends App {

  println(calculate(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
  println(calculate(Array(1, 8, 6, 2, 5, 4, 8, 3, 7,9)))

  def calculate(arr: Array[Int]): Int = {
    var max = 0
    for (len <- (arr.size - 1) until (0,-1)) {
      for (i <- 0 until (len)) {
        val tmp = if (arr(i) < arr(len)) arr(i) else arr(len)
        val ta = (len - i) * tmp
        max = if (ta > max) ta else max
      }
    }
    max
  }

}
