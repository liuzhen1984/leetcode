package eighth.string_to_int_atoi

import org.scalatest.funspec.AnyFunSpec

class StringToIntAtoiTest extends AnyFunSpec{
  describe("eighth:StringToIntAtoiTest") {
    it("1") {
      assert(StringToIntAtoi.stringToInteger("ab") == 0)
      assert(StringToIntAtoi.stringToInteger("42") == 42)
      assert(StringToIntAtoi.stringToInteger("-42") == -42)
      assert(StringToIntAtoi.stringToInteger("4193 with words") == 4193)
      assert(StringToIntAtoi.stringToInteger("words and 987") == 0)
      assert(StringToIntAtoi.stringToInteger("-91283472332") == -2147483648)
      assert(StringToIntAtoi.stringToInteger("91283472332") == 2147483647)
    }
  }

}
