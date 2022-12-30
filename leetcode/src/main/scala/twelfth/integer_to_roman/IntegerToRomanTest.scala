package twelfth.integer_to_roman

import org.scalatest.funspec.AnyFunSpec

class IntegerToRomanTest extends AnyFunSpec{
  describe("Thirteenth:IntegerToRomanTest") {
    it("1") {
      assert(IntegerToRoman.getRomanValue(1) == "I")
      assert(IntegerToRoman.getRomanValue(3) == "III")
      assert(IntegerToRoman.getRomanValue(4) == "IV")
      assert(IntegerToRoman.getRomanValue(9) == "IX")
      assert(IntegerToRoman.getRomanValue(58) == "LVIII")
      assert(IntegerToRoman.getRomanValue(1994) == "MCMXCIV")
      assert(IntegerToRoman.getRomanValue(3999) == "MMMCMXCIX")
    }
  }

}
