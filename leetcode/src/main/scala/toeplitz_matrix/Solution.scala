package toeplitz_matrix

object Solution {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    var result = false
    for (y <- 0 until matrix.length) {
      if (y == 0) {
        for (x <- 0 until matrix(y).length) {
          result = check(matrix(y)(x), x, y, matrix)
          if (!result) {
            return result
          }
        }
      } else {
        result = check(matrix(y)(0), 0, y, matrix)
        if (!result) {
          return result
        }
      }

    }
    return result

  }

  def check(value: Int, x: Int, y: Int, matrix: Array[Array[Int]]): Boolean = {
    if (y > matrix.length - 1 || x > matrix(0).length - 1) {
      return true
    }
    println(s"y=${x},x=${y},matrix=${matrix(y)(x)}")

    if (matrix(y)(x) == value) {
      check(value, x + 1, y + 1, matrix)
    } else {
      return false
    }
  }
}
