package thirteenth.roman_to_integer

import org.scalatest.funspec.AnyFunSpec

class RomanToIntegerTest extends AnyFunSpec{
  describe("Thirteenth:IntegerToRomanTest") {
    it("1") {
      assert(RomanToInteger.getInteger("III") == 3)
      assert(RomanToInteger.getInteger("IV") == 4)
      assert(RomanToInteger.getInteger("IX") == 9)
      assert(RomanToInteger.getInteger("LVIII") == 58)
      assert(RomanToInteger.getInteger("MCMXCIV") == 1994)
      assert(RomanToInteger.getInteger("MMMCMXCIX") == 3999)
//      assert(RomanToInteger.getInteger(3) == "III")
//      assert(RomanToInteger.getInteger(4) == "IV")
//      assert(RomanToInteger.getInteger(9) == "IX")
//      assert(RomanToInteger.getInteger(58) == "LVIII")
//      assert(RomanToInteger.getInteger(1994) == "MCMXCIV")
//      assert(RomanToInteger.getInteger(3999) == "MMMCMXCIX")
    }
  }

}
