package twothousandfourhundredfortyninth.mini_remove_to_make_valid_parentheses

import org.scalatest.funspec.AnyFunSpec

import scala.collection.mutable._

class MiniRemoveMakeValidParenthesesTest extends AnyFunSpec {
  describe("Thirteenth:IntegerToRomanTest") {
    it("1") {
      assert(MiniRemoveMakeValidParentheses.removeInvalidParentheses("lee(t(c)o)de)") == "lee(t(c)o)de")
      assert(MiniRemoveMakeValidParentheses.removeInvalidParentheses("a)b(c)d") == "ab(c)d")
      assert(MiniRemoveMakeValidParentheses.removeInvalidParentheses("))((") == "")
      assert(MiniRemoveMakeValidParentheses.removeInvalidParentheses("(a(b(c)d)") == "a(b(c)d)")
      assert(MiniRemoveMakeValidParentheses.removeInvalidParentheses("))ab(c(d)((a") == "abc(d)a")
      assert(MiniRemoveMakeValidParentheses.removeInvalidParentheses("a))((abc(b))(bd(ad)b))))") == "a((abc(b))(bd(ad)b))")
    }
  }
}
