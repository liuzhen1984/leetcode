package seventh.revers_integer

import org.scalatest.funspec.AnyFunSpec


class ReverseIntegerTest extends AnyFunSpec{
  describe("Fifth:LongestPalindromicSubstring") {
    it("1") {
      assert(ReverseInteger.reverse(1)==1)
    }
    it("2") {
      assert(ReverseInteger.reverse(321)==123)

    }
    it("3") {
      assert(ReverseInteger.reverse(-321) == -123)

    }
    it("4") {
      assert(ReverseInteger.reverse(120)==21)

    }
    it("5") {
      assert(ReverseInteger.reverse(1534236469)==0)
    }

  }
}
