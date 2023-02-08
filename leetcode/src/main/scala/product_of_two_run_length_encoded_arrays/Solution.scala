package product_of_two_run_length_encoded_arrays

import scala.collection.mutable

object Solution extends App {
  val list1: Array[Array[Int]] = Array(Array(1, 2), Array(4, 5), Array(1, 2), Array(6, 7), Array(6, 7))

  val list2: Array[Array[Int]] = Array(Array(2, 1), Array(4, 1), Array(1, 2), Array(6, 7))

  println(findRLEArray(list1, list2))
  println(findRLEArray2(list1, list2))

  def findRLEArray(encoded1: Array[Array[Int]], encoded2: Array[Array[Int]]): List[List[Int]] = {
    var decode2 = mutable.ListBuffer[Int]()
    for (en <- encoded2) {
      decode2.appendAll(((en(0).toString + ",") * en(1)).split(",").map(_.toInt).toList)
    }
    val resultList = mutable.ListBuffer[List[Int]]()
    for (en <- encoded1) {

      val tmp = decode2.splitAt(en(1))
      decode2 = tmp._2
      val list = (((en(0).toString + ",") * en(1)).split(",").map(_.toInt).toList zip tmp._1).map(i => i._1 * i._2)
      var tmpList = List[Int]()
      if(resultList.size>0){
        tmpList = resultList(resultList.length-1)
        resultList.remove(resultList.length-1)
      }

      for (r <- list) {
        if (tmpList.size>0 && tmpList(0) == r) {
          tmpList = List[Int](r, tmpList(1) + 1)
        } else {
          if (tmpList.size > 0) {
            resultList.append(tmpList)
          }
          tmpList = List[Int](r, 1)
        }
      }
      if (tmpList.size > 0) {
        resultList.append(tmpList)
      }
    }
    resultList.toList
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
    println((decode1 zip decode2).map(i => i._1 * i._2))
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
