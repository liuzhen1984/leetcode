package sixhundredeightieth

import org.scalatest.funspec.AnyFunSpec

class ValidPalindromeTest extends AnyFunSpec{
  describe("eighth:PalindromeNumberTest") {
    it("1") {
      assert(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"))
      assert(ValidPalindrome.isPalindrome("abccba"))
      assert(ValidPalindrome.isPalindrome("0"))
      assert(!ValidPalindrome.isPalindrome("0p"))
      assert(!ValidPalindrome.isPalindrome("race a car"))
      assert(ValidPalindrome.validPalindrome("amanaplanacanalpanaama"))

    }
  }

}
