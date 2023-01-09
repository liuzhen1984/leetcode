package random_pick_with_weight

import scala.util.Random

class RandomPickWithWeight(_w: Array[Int]) {

  var weightList: List[Int]=List()
  def pickIndex(): Int = {
    if (_w.length <= 1) {
      return 0
    }
    val random = new Random()
    var end = this.weightList.length-1
    val index = random.nextInt(weightList(end))
    var start = 0
    println(s"index=$index,end=$end")
    while(start < end){
      var mid = start+(end-start)/2;
      if(this.weightList(mid) <= index) start = mid+1;
      else end = mid
    }
    return end
  }

}

object RandomPickWithWeight extends App {
  val r = RandomPickWithWeight(Array(3, 14, 1,7))
  println(r.weightList)
  println(r.pickIndex())
  println(r.pickIndex())
  println(r.pickIndex())
  println(r.pickIndex())
  println(r.pickIndex())
  println(r.pickIndex())

  def apply(_w: Array[Int]): RandomPickWithWeight = {
    val r = new RandomPickWithWeight(_w)
    var total = 0
    r.weightList = _w.toStream.map(i=>{total = i + total;total}).toList
    r
  }
}
