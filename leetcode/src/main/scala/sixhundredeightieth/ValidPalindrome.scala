package sixhundredeightieth

object ValidPalindrome extends App {
  println(isPalindrome("abccde"))
  println(isPalindrome("0"))
  println(isPalindrome("0p"))
  println(isPalindrome("race a car"))
  println(isPalindrome("A man, a plan, a canal: Panama"))
  println(isPalindrome("A man, a plan, a canl: Panma"))
  def isPalindrome(str:String):Boolean={
    if(str.length==1){
      return true
    }
    if(str.length==2){
      return str(0)==str(1)
    }
    for(i<-1 until str.length-1){
      if((str(i+1)>='a' && str(i+1)<='z') || (str(i+1)>='A' && str(i+1)<='Z') || (str(i+1)>='0' && str(i+1)<='9')){
        if (str(i) == str(i + 1) || str(i - 1) == str(i + 1)) {
          return true
        }
      }

    }
    false
  }
}
