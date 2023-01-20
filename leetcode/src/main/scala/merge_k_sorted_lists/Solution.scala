package merge_k_sorted_lists

case class ListNode(x: Int, var next: ListNode)

object Solution {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    var result: ListNode = null
    for (i <- 0 until lists.length) {
      if (result == null) {
        result = lists(i)
      } else {
        var tmp = lists(i)
        while (tmp != null) {
          result = deep(tmp, result)
          tmp = tmp.next
        }
      }
    }
    result
  }

  def deep(node: ListNode, result: ListNode): ListNode = {
    if (result == null) {
      return ListNode(node.x, null)
    }
    if (node.x <= result.x) {
      return ListNode(node.x, result)
    } else {
      result.next = deep(node, result.next)
    }
    return result
  }
}
