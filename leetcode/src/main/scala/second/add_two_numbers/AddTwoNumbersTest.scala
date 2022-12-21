package second.add_two_numbers

import org.scalatest.funspec.AnyFunSpec

class AddTwoNumbersTest extends AnyFunSpec {
  describe("Second:AddTwoNumbersTest") {
    it("1") {
      val list1 = List(0, 3, 4, 5, 6, 7)
      val list2 = List(4, 9)
      assert(AddTwoNumbers.add(list1, list2) == List(4, 2, 5, 5, 6, 7))
    }
    it("2") {
      val list1 = List(0, 3, 4, 5, 6, 7)
      val list2 = List(4, 9, 1, 3, 4, 5, 9)
      assert(AddTwoNumbers.add(list1, list2) == List(4,2,6,8,0,3,0,1))
    }
    it("3") {
      val list1 = List()
      val list2 = List()
      assert(AddTwoNumbers.add(list1, list2) == List())
    }
    it("4") {
      val list1 = List(1)
      val list2 = List(2)
      assert(AddTwoNumbers.add(list1, list2) == List(3))
    }
    it("5") {
      val list1 = List(9)
      val list2 = List(9)
      assert(AddTwoNumbers.add(list1, list2) == List(8,1))
    }
  }
}
