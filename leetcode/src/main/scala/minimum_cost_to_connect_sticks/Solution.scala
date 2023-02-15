package minimum_cost_to_connect_sticks

object Solution extends App {
//  println(connectSticks(Array(2,4,3))==14)
//  println(connectSticks(Array(1,8,3,5))==30)
//  println(connectSticks(Array(5))==0)
//  println(connectSticks(Array(3354,4316,3259,4904,4598,474,3166,6322,8080,9009)))
  def connectSticks(sticks: Array[Int]): Int = {
    if(sticks.length<=1){
      return 0
    }
    def deep(list:Array[Int]):Int={
      val tmp = list.sortBy(i=>i).splitAt(2)
      val total = tmp._1.sum
      if(list.length<=2){
        return total
      }
      total+ deep(Array(total)++tmp._2)
    }
    deep(sticks)
  }


}
