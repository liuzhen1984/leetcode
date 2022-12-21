package first.two_sum

import org.scalatest.funsuite.AnyFunSuite

class TwoSumTestBySuite extends AnyFunSuite {

  test("two sum used map"){
    val list = List(1,4,6,7,8)
    val result = TwoSum.getIndexByMap(10,list)
    assert(result==List(1,2))
  }
  test("two sum used recursion") {
    val list = List(1, 4, 6, 7, 8)
    val result = TwoSum.getIndex(10, list)
    assert(result == List(1, 2))
  }

}
