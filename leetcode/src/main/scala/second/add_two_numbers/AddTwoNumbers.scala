package second.add_two_numbers

import scala.collection.mutable.ListBuffer

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 2 个逆序的链表，要求从低位开始相加，得出结果也逆序输出，返回值是逆序结果链表的头结点。
 *
 *
 */
object AddTwoNumbers extends App {

  val result = add(List(1,3,4),List(2,4,5))
  println(result)

  def add(a: List[Int], b: List[Int]): List[Int] = {
    val len = if (a.length > b.length) a.length else b.length
    val result :ListBuffer[Int] = ListBuffer()
    var next = 0
    for (i <- 0 until len) {
       var av = 0;
       var bv = 0;
       if(i<a.length){
          av = a(i)
       }
      if( i<b.length) {
        bv = b(i)
      }

      val value = next+(av+bv) % 10
      result.append(if (value==10) 0 else value)
      next = (next + av + bv) / 10

    }
    if(next>0){
      result.append(next)
    }
    result.toList
  }

}
