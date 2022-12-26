package sixth.zigzag_conversion

import org.scalatest.funspec.AnyFunSpec

class ZigZagConversionTest extends AnyFunSpec {
  describe("Second:AddTwoNumbersTest") {
    it("1") {
      assert(ZigZagConversion.getZString("PAYPALISHIRING",3)== "PAHNAPLSIIGYIR")
    }
    it("2") {
      assert(ZigZagConversion.getZString("PAYPALISHIRING",4)== "PINALSIGYAHRPI")

    }
    it("3") {
      assert(ZigZagConversion.getZString("A",1)== "A")

    }

  }
}
