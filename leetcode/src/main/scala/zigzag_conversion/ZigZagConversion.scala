package zigzag_conversion

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * 题目大意
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 解题思路
 * 这一题没有什么算法思想，考察的是对程序控制的能力。用 2 个变量保存方向，当垂直输出的行数达到了规定的目标行数以后，需要从下往上转折到第一行，循环中控制好方向ji
 * 代码
 * package leetcode
 *
 * func convert(s string, numRows int) string {
 * matrix, down, up := make([][]byte, numRows, numRows), 0, numRows-2
 * for i := 0; i != len(s); {
 * if down != numRows {
 * matrix[down] = append(matrix[down], byte(s[i]))
 * down++
 * i++
 * } else if up > 0 {
 * matrix[up] = append(matrix[up], byte(s[i]))
 * up--
 * i++
 * } else {
 * up = numRows - 2
 * down = 0
 * }
 * }
 * solution := make([]byte, 0, len(s))
 * for _, row := range matrix {
 * for _, item := range row {
 * solution = append(solution, item)
 * }
 * }
 * return string(solution)
 * }
 */
object ZigZagConversion extends App {

  println(getZString("PAYPALISHIRING", 5))

  def getZString(str: String, numRows: Int): String = {
    if (str.length <= numRows) {
      println(str)
      str
    }
    else {
      val row = numRows
      val tmp = str.length / (numRows + numRows)
      val column = (tmp + 1) * numRows + numRows
      val twoArray: Array[Array[Char]] = new Array[Array[Char]](row)
      for (i <- 0 until (twoArray.length)) {
        twoArray.update(i, new Array[Char](column))
      }
      var rt = 0
      var rc = 0
      var label = true
      var space = false
      for (s <- str) {
        if (label) {
          if (rt < row - 1) {
            if (rc < column) {

              twoArray(rt)(rc) = s
              rt += 1
            }
          } else {

            twoArray(rt)(rc) = s
            rc += 1
            label = false
            rt -= 1

          }
        } else {
          if (rt > 0) {
            if (rc < column) {
              twoArray(rt)(rc) = s
              rt -= 1
              rc += 1
            }
          } else {
            label = true
            twoArray(rt)(rc) = s
            rt += 1
          }
        }

      }
      val result = new StringBuffer()
      for (sa <- twoArray) {
        for (s <- sa) {
          if (!s.isLetterOrDigit) {
            print("\t")
          } else {
            print(s"\t${s.toString}")
            result.append(s)
          }

        }
        println("")
      }
      return result.toString
    }
  }

  def setSpace(s: Char, space: Boolean): (Char, Boolean) = {

    if (space) {
      (' ', false)
    } else {
      (s, true)
    }
  }
}
