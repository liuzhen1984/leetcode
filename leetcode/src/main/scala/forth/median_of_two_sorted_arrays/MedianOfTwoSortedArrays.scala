package forth.median_of_two_sorted_arrays

/**
 *
 */
object MedianOfTwoSortedArrays extends App {

  def getMedianValue(listA:Array[Int],listB:Array[Int]):Double={
    if(listA.length>listB.length){
      return getMedianValue(listB,listA)
    }
    var aIndex = listA.length/2
    var bIndex = listB.length/2
    var result = 0.0

    while (true){
      if(aIndex<listA.length-1 || aIndex>listA.length || bIndex<listB.length-1|| bIndex>listB.length){
        return result
      }
      if (listA(aIndex - 1) <= listB(bIndex) && listB(bIndex - 1) <= listA(aIndex)) {


      }
      val tmp = listA(aIndex-1)
      if(listA(aIndex)<listB(bIndex-1)){
        aIndex += 1
      }
      if(tmp>listB(bIndex)){
        aIndex -= 1
      }
    }

     result
  }

}
