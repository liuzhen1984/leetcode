package onesevensixtwo
import scala.collection.mutable._
object BuildingsWithAnOceanView extends App {

  println(findBuildings(Array(3,4,5,3,1,2,5,2,1)))
  def findBuildings(buildings:Array[Int]):Array[Int]={

    def max(build:Int,index:Int):Boolean={
      for(b<-index until buildings.length){
        if(build<=buildings(b)){
          return false
        }
      }
      true
    }
    val result=ListBuffer[Int]()
    for(b<-buildings.indices){
      if (max(buildings(b), b + 1)) {
        result.append(b)
      }
    }
    result.toArray
  }
}
