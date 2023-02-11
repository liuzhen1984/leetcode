package maximum_swap

object Solution extends App {
  println(maximumSwap(12345))
  println(maximumSwap(5341))
  println(maximumSwap(54321))
  println(maximumSwap(93868))
  def maximumSwap(num: Int): Int = {
    val numArray = num.toString.toArray
    val numArraySort = numArray.sortBy(i => i).reverse
    if(numArraySort.mkString("").toInt==num){
      return num
    }
    var s = 0
    for (i <- 0 until  numArray.length) {
//      println(numArraySort(s))
      if (numArray(i) < numArraySort(s)) {
        val index = numArray.lastIndexOf(numArraySort(s))
        val tmp = numArray(i)
        numArray(i) = numArraySort(s)
        numArray(index) = tmp
        return numArray.mkString("").toInt
      }
      s += 1
    }
    num
  }
}
