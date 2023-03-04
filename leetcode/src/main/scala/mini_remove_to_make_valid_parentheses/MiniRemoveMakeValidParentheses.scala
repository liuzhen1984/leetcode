package twothousandfourhundredfortyninth.mini_remove_to_make_valid_parentheses
import scala.collection.mutable._
object MiniRemoveMakeValidParentheses extends App {

  println(removeInvalidParentheses("a))((abc(b))(bd(ad)b))))"))
  println(removeInvalidParentheses("))(("))
  println(removeInvalidParentheses("))ab(c(d)((a"))

  def removeInvalidParentheses(str:String):String={
    val left = new ArrayBuffer[Int]()
    val removeIndexBuffer = new ArrayBuffer[Int]()

    for(i<- 0 until str.length){
      if(str(i)=='('){
        left.append(i)
      }
      if(str(i)==')'){
        if(left.length>0){
          left.remove(left.length-1)
        }else{
          removeIndexBuffer.append(i)
        }
      }
    }
    if(left.size>0){
      removeIndexBuffer.appendAll(left)
      left.clear()
    }

    if(removeIndexBuffer.size==0){
      return str
    }
    val result = new StringBuffer()
    var start = 0
    for(i<-removeIndexBuffer){
      if(i>0){
        result.append(str.substring(start,i))
      }
      start = i+1
    }
    if(start>0){
      result.append(str.substring(start))
    }
    result.toString
  }

}
