package add_strings

object Solution extends App {
  println(addStrings("691325924499999999999999999999999999999999999999","71103343"))
  def addStrings(num1: String, num2: String): String = {
    var result = ""
    var sum = 0
    var num2Index = num2.length - 1
    var num1Index = num1.length - 1
    var sumLen = 0
    val len = if (num2Index > num1Index) num2Index else num1Index
    for (i <- 0 to len) {
      var tmp = ("1"+"0"*sumLen).toInt
      if (num2Index >= 0) {
        sum =sum+num2(num2Index).getNumericValue*tmp
      }
      if (num1Index >= 0) {
        sum =sum+num1(num1Index).getNumericValue*tmp
      }
      println(s"tmp=$tmp,result=$result,sum=$sum, sumLen=$sumLen,len=$len,num2Index=$num2Index,num1=$num1Index")
      if (sumLen > 7 || sumLen>=len || i>=len) {
        if (sum.toString.length > sumLen+1 && i<len) {
          result = sum.toString.substring(1,sum.toString.length) + result
          sum = sum.toString.substring(0,1).toInt
        } else {
          var zero = ""
          if(sum.toString.length<9 && i<len){
            zero = "0"*(9-sum.toString.length)
          }
          result = zero + sum.toString + result
          sum = 0
        }
        sumLen = 0
      }else{
        sumLen += 1
      }
      num2Index -= 1
      num1Index -= 1
    }
    result
  }
}
