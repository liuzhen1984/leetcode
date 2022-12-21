package first.two_sum

import scala.collection.mutable
import scala.io.StdIn

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标。
 *
 * 解题思路：
 * 个人思路（过于复杂，适合数据量大的）
 * 1. 找到所有比给出的值小的列表
 * 2. 从小大大排序
 * 3. 从小开始，用目标值依次减去值，如果为零则找到，否则循环下一次
 *
 * 其他人给的：
 * 这道题最优的做法时间复杂度是 O(n)。
 * 顺序扫描数组，对每一个元素，在 map 中找能组合给定值的另一半数字，如果找到了，直接返回 2 个数字的下标即可。如果找不到，就把这个数字存入 map 中，等待扫到“另一半”数字的时候，再取出来返回结果。
 * (这里使用递归算法）
 */
object TwoSum {

  def main(args: Array[String]): Unit = {
    val list = List[Int](2, 4, 5, 6, 7, 8, 12, 43,23,4,6,45,67,67,65)
    while (true) {
      printf("Please input your target number: ")
      try {
        val x: Int = StdIn.readInt().toInt
        val result:List[Int] = getIndex( x, list)
        if (list(0) < 0 || list(1) < 0) {
          println("They aren't in the list ")
        } else {
          println(s"index = (${result(0)},${result(1)}), value = ${list(result(0))},${list(result(1))} ")
        }
      }catch {
        case _ => println(s"You input value is wrong format, please input a numerical")
      }
    }
  }

  //map O(n) 时间复杂度
  def getIndexByMap(target:Int,list:List[Int]):List[Int] = {
    val map:mutable.Map[Int,Int] = mutable.Map()

    val idx = 0;
    for( i <- 0 until(list.length)){
      if(map.contains(target-list(i))){
        return List(map.get(target-list(i)).get,i)
      }
      map(list(i)) = i
    }
    Nil
  }

  //递归方法 O(n*n) n平方的时间复杂度
  def getIndex(target:Int,list:List[Int]):List[Int] = {
    return findTarget(0,target, list)
  }

  def findTarget(firstIndex: Int, target: Int, list: List[Int]): List[Int] = {
    if (firstIndex >= list.length) {
      return Nil
    }
    for (i <- 0 until  list.length ) {
      if (i != firstIndex && list(i) < target && (list(i) + list(firstIndex)) == target) {
        return List(firstIndex, i)
      }
    }
    findTarget(firstIndex + 1, target, list)
  }


}
