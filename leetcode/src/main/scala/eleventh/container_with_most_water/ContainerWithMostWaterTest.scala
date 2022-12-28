package eleventh.container_with_most_water

import org.scalatest.funspec.AnyFunSpec

class ContainerWithMostWaterTest extends AnyFunSpec{
  describe("eighth:PalindromeNumberTest") {
    it("1") {
      assert(ConatinerWithMostWater.calculate(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
      assert(ConatinerWithMostWater.calculate(Array(1, 8, 6, 2, 5, 4, 8, 3, 7,9)) == 64)
      assert(ConatinerWithMostWater.calculate(Array(1, 8, 6, 2, 5, 4, 8, 3, 7,9,10)) == 72)
    }
  }
}
