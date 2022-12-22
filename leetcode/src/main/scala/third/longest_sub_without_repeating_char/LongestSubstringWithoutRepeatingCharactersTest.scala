package third.longest_sub_without_repeating_char

import org.scalatest.funspec.AnyFunSpec

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * In put: "abcabcbb"
 * O utput: 3
 * E xplanation: The answer is "abc", with the length of 3.
 * E xample 2:
 *
 * I n put: "bbbbb"
 * O utput: 1
 * E xplanation: The answer is "b", with the length of 1.
 * E xample 3:
 *
 * I n put: "pwwkew"
 * O utput: 3
 * E xplanation: The answer is "wke", with the length of 3.
 * N ote that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 题目大意
在一个字符串中寻找没有重复字母的最长子串。

解题思路
这一题和第 438 题，第 3 题，第 76 题，第 567 题类似，用的思想都是"滑动窗口"。

滑动窗口的右边界不断的右移，只要没有重复的字符，就持续向右扩大窗口边界。一旦出现了重复字符，就需要缩小左边界，直到重复的字符移出了左边界，然后继续移动滑动窗口的右边界。以此类推，每次移动需要计算当前长度，并判断是否需要更新最大长度，最终最大的值就是题目中的所求。
 */

class LongestSubstringWithoutRepeatingCharactersTest extends AnyFunSpec {
  describe("Third:LongestSubstringWithoutRepeatingCharactersTest") {
    it("1") {
      assert(LongestSubstringWithoutRepeatingCharacters.getLongestCharacters("abc")==("abc",3))
    }
    it("2") {
      assert(LongestSubstringWithoutRepeatingCharacters.getLongestCharacters("aabcc") == ("abc",3))
    }
    it("3") {
      assert(LongestSubstringWithoutRepeatingCharacters.getLongestCharacters("aabbccdd") == ("ab",2))
    }
    it("4") {
      assert(LongestSubstringWithoutRepeatingCharacters.getLongestCharacters("zlliiu223142") == ("2314", 4))
    }
  }

}
