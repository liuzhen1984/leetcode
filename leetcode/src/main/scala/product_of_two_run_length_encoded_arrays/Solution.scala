package product_of_two_run_length_encoded_arrays

import scala.collection.mutable

object Solution extends App {
  val list1: Array[Array[Int]] = Array(Array(1, 2), Array(4, 5), Array(1, 2), Array(6, 7), Array(6, 7))

  val list2: Array[Array[Int]] = Array(Array(2, 1), Array(4, 1), Array(1, 2), Array(6, 7),Array(1,1))

  println(findRLEArray(list1, list2))
  println(findRLEArray2(list1, list2))
  println(productRLA(List((1, 2), (4, 5), (1, 2), (6, 7), (6, 7)), List((2, 1), (4, 1), (1, 2), (6, 7))))
  println(multiply(list1, list2))

  def findRLEArray(encoded1: Array[Array[Int]], encoded2: Array[Array[Int]]): List[List[Int]] = {
    var e1 = 0
    var e2 = 0
    var resultList = mutable.ListBuffer[List[Int]]()
    while (e1 < encoded1.length) {
      val len = Math.min(encoded1(e1)(1), encoded2(e2)(1))
      val mut = encoded1(e1)(0) * encoded2(e2)(0)
      if (resultList.length > 0 && resultList(resultList.length - 1)(0) == mut) {
        resultList(resultList.length - 1) = List(mut, resultList(resultList.length - 1)(1) + len)
      } else {
        resultList.append(List(mut, len))
      }
      encoded1(e1)(1) -= len
      encoded2(e2)(1) -= len
      if (encoded1(e1)(1) == 0) e1 += 1
      if (encoded2(e2)(1) == 0) e2 += 1
    }

    return resultList.toList

  }
  def multiply(encoded1: Array[Array[Int]], encoded2: Array[Array[Int]]): List[List[Int]] = {
    val nums1 = encoded1.flatMap(x => Array.fill(x(1))(x(0)))
    val nums2 = encoded2.flatMap(x => Array.fill(x(1))(x(0)))
    val prodNums = nums1.zip(nums2).map(x => x._1 * x._2)

    var res = List[List[Int]]()
    var i = 0
    while (i < prodNums.length) {
      var j = i
      while (j < prodNums.length && prodNums(j) == prodNums(i)) {
        j += 1
      }
      res = List(prodNums(i), j - i) :: res
      i = j
    }
    res.reverse
  }

  def productRLA(a: List[(Int, Int)], b: List[(Int, Int)]): List[(Int, Int)] = {
    (a, b).zipped.map { case ((va, la), (vb, lb)) => (va * vb, math.min(la, lb)) }
  }



  def findRLEArray2(encoded1: Array[Array[Int]], encoded2: Array[Array[Int]]): List[List[Int]] = {

    val decode1 = mutable.ListBuffer[Int]()
    for (en <- encoded1) {
      decode1.appendAll(((en(0).toString + ",") * en(1)).split(",").map(_.toInt).toList)
    }
    val decode2 = mutable.ListBuffer[Int]()
    for (en <- encoded2) {
      decode2.appendAll(((en(0).toString + ",") * en(1)).split(",").map(_.toInt).toList)
    }
    val resultList = mutable.ListBuffer[List[Int]]()
    var tmpValue = 0
    var tmpList = List[Int]()
    //    println((decode1 zip decode2).map(i => i._1 * i._2))
    (decode1 zip decode2).map(i => i._1 * i._2).foreach(r => {
      if (tmpValue == r) {
        tmpList = List[Int](r, tmpList(1) + 1)
      } else {
        tmpValue = r
        if (tmpList.size > 0) {
          resultList.append(tmpList)
        }
        tmpList = List[Int](r, 1)
      }
    })
    if (tmpList.size > 0) {
      resultList.append(tmpList)
    }
    resultList.toList
  }
}
