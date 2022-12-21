package first.two_sum

import org.scalatest.funspec.AnyFunSpec

class TwoSumTest extends AnyFunSpec{
  describe("First:TwoSum"){
    it("use map to implement 1"){
      val list = List(0,3,4,5,6,7)
      assert(TwoSum.getIndexByMap(7,list) == List(1,2))
    }
    it("use map to implement 2") {
      val list = List(10, 3, 4, 5, 6, 7,100)
      assert(TwoSum.getIndexByMap(104, list) == List(2, 6))
    }

    it("use map to implement 3") {
      val list = List(10, 3, 4, 5, 6, 7, 100)
      assert(TwoSum.getIndexByMap(109, list) == Nil)
    }

    it("use map to implement 4") {
      val list = List(10, 3, 4, 5, 6, 7, 100)
      assert(TwoSum.getIndexByMap(107, list) == List(5,6))
    }

    it("use map to recursion") {
      val list = List(0, 3, 4, 5, 6, 7)
      assert(TwoSum.getIndex(7, list) == List(1, 2))
    }
  }

}
