package next_permutation

object Solution extends App {
  nextPermutation(Array(4, 2, 0, 2, 3, 2, 0))
  //  nextPermutation(Array(1, 3, 2))
  //  nextPermutation(Array(1, 3, 4))
    nextPermutation(Array(3, 2, 1))
  //  nextPermutation(Array(1, 2, 3))
  //  nextPermutation(Array(1, 1, 5))
  //  nextPermutation(Array(1, 2, 3, 4, 5, 6))
  //  nextPermutation(Array(1, 2, 2, 4, 2, 3, 9, 12, 1))

  def nextPermutation(nums: Array[Int]): Unit = {
    def sort(start: Int): Unit = {
      var i = start
      while (i < nums.length - 1) {
        for (j <- i + 1 until nums.length) {
          if (nums(i) > nums(j)) {
            switch(i, j)
          }
        }
        i += 1
      }
    }

    def reverts(): Unit = {
      var i = 0
      var j = nums.length - 1
      while (i < j) {
        switch(i, j)
        i += 1
        j -= 1
      }
    }

    def switch(i: Int, j: Int): Unit = {
      var tmp = 0
      tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }
    var i = nums.length - 1
    var findi = -1
    var findj = -1
    while (i > 0) {
      var j = i-1
      while (j >= 0) {
        if (nums(i) > nums(j)) {
          if (findj < j ) {
            findi = i
            findj = j
          }
          j = -1
        }
        j -= 1
      }
      i -= 1
    }
    if (findi != -1  && findj != -1 ) {
     switch(findi,findj)
    }
    if (findj == -1) {
      reverts()
    } else {
      sort(findj+1)
    }
    nums.foreach(print)
    println("")
  }

}
