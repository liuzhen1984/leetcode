package third.longest_sub_without_repeating_char


import scala.collection.mutable.ListBuffer

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
 */

object LongestSubstringWithoutRepeatingCharacters {

  def main(args: Array[String]): Unit = {
    println(getLongestCharacters("zlliiu223142"))
  }


  def getLongestCharacters(character: String): (String, Int) = {
    var maxStr: ListBuffer[Char] = ListBuffer()
    var buffer: ListBuffer[Char] = ListBuffer()
    for (i <- character) {
      if (buffer.length == 0) {
        buffer.append(i)
      } else {
        if (buffer.contains(i)) {
          if (buffer.length > maxStr.length) {
            maxStr = buffer.clone()
          }
          buffer.clear()
        }
        buffer.append(i)

      }
    }
    if (buffer.length > maxStr.length) {
      maxStr = buffer.clone()
    }

    (maxStr.mkString(""), maxStr.length)
  }

}
