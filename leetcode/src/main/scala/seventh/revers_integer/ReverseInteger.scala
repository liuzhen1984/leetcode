package seventh.revers_integer

object ReverseInteger extends App {
  println(reverse(-2137483649))

  def reverse(v:Int):Int={
    var value = v
    var p=0L;
    while(value != 0){
      p = p*10+ value%10
      value = value/10
    }
    if(p< - (1<<31) || p > (1<<31-1) ){
      println("Value of the overflow integer")
      return 0
    }
    p.toInt
  }
}
