package ninth.palindrome_number

import org.scalatest.funspec.AnyFunSpec

class PalindromeNumberTest extends AnyFunSpec{
  describe("eighth:PalindromeNumberTest") {
    it("1") {
      assert(PalindromeNumber.isPalindromeNumber(123) == false)
      assert(PalindromeNumber.isPalindromeNumber(121) == true)
      assert(PalindromeNumber.isPalindromeNumber(-121) == false)
      assert(PalindromeNumber.isPalindromeNumber(1534236469) == false)
      assert(PalindromeNumber.isPalindromeNumber(0) == true)
      assert(PalindromeNumber.isPalindromeNumber(5) == true)
      assert(PalindromeNumber.isPalindromeNumber(120) == false)
      assert(PalindromeNumber.isPalindromeNumber(120021) == true)
      assert(PalindromeNumber.isPalindromeNumber(321) == false)
      assert(PalindromeNumber.isPalindromeNumber(10) == false)
    }
  }
}
