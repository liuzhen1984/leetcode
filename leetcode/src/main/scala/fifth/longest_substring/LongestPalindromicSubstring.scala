package fifth.longest_substring

import scala.collection.mutable

/** Given a string s, return the longest palindromic substring in s.
 *
 *Example 1:
 *
 *Input: s = "babad"
*Output: "bab"
*Note: "aba" is also a valid answer.
 *
 *Example 2:
 *
 *Input: s = "cbbd"
*Output: "bb"
 *
 *Example 3:
 *
 *Input: s = "a"
*Output: "a"
 *
 *Example 4:
 *
 *Input: s = "ac"
*Output: "a"
 *
 *Constraints:
 *
 *1 <= s.length <= 1000
*s consist of only digits and English letters (lower-case and/or upper-case),
*题目大意
*给你一个字符串 s，找到 s 中最长的回文子串。
 */

case class ValueTmp(headIndex:Int,len:Int,tailIndex:Int)
object LongestPalindromicSubstring extends App{

  println(getLongestSubstring("ab"))
  println(getLongestSubstring("abc"))
  println(getLongestSubstring("aba"))
  println(getLongestSubstring("abcda"))
  println(getLongestSubstring("abcda23c"))
  println(getLongestSubstring("abcda23c3523a"))
  println(getLongestSubstring("ajgiljtperkvubjmdsefcylksrxtftqrehoitdgdtttswwttmfuvwgwrruuqmxttzsbmuhgfaoueumvbhajqsaxkkihjwevzzedizmrsmpxqavyryklbotwzngxscvyuqjkkaotitddlhhnutmotupwuwyltebtsdfssbwayuxrbgihmtphshdslktvsjadaykyjivbzhwujcdvzdxxfiixnzrmusqvwujjmxhbqbdpauacnzojnzxxgrkmupadfcsujkcwajsgintahwgbjnvjqubcxajdyyapposrkpqtpqfjcvbhlmwfutgognqxgaukpmdyaxghgoqkqnigcllachmwzrazwhpppmsodvxilrccfqgpkmdqhoorxpyjsrtbeeidsinpeyxxpsjnymxkouskyhenzgieybwkgzrhhrzgkwbyeigznehyksuokxmynjspxxyepnisdieebtrsjypxroohqdmkpgqfccrlixvdosmppphwzarzwmhcallcginqkqoghgxaydmpkuagxqngogtufwmlhbvcjfqptqpkrsoppayydjaxcbuqjvnjbgwhatnigsjawckjuscfdapumkrgxxznjozncauapdbqbhxmjjuwvqsumrznxiifxxdzvdcjuwhzbvijykyadajsvtklsdhshptmhigbrxuyawbssfdstbetlywuwputomtunhhlddtitoakkjquyvcsxgnzwtoblkyryvaqxpmsrmzidezzvewjhikkxasqjahbvmueuoafghumbszttxmquurrwgwvufmttwwstttdgdtioherqtftxrsklycfesdmjbuvkreptjligja"))
  def getLongestSubstring(value:String):String={
    if(value.length<1||value.length>1000){
      return ""
    }
    val valueMap = mutable.Map[Char,ValueTmp]()
    for( i<- 0 until( value.length)){
      if(valueMap.contains(value(i))){
         val char = valueMap.get(value(i)).get
         if(char.tailIndex>0){
           if(i-char.tailIndex>char.len){
             valueMap.put(value(i),ValueTmp(char.tailIndex,i-char.tailIndex,i))
           }
         }else{
           valueMap.put(value(i),ValueTmp(char.headIndex,i-char.headIndex,i))
         }
      }else{
        valueMap.put(value(i),ValueTmp(i,0,-1))
      }
    }
    var tmp:ValueTmp=null
    var defaultValue:ValueTmp = null;
    for(v<-valueMap.values){
      if(tmp==null){
        tmp = v
      }
      if(tmp.len<v.len){
        tmp = v
      }
      if(v.headIndex==0){
        defaultValue = v
      }
    }
    if(tmp.len==0){
      return value(defaultValue.headIndex).toString
    }
    return value.substring(tmp.headIndex,tmp.tailIndex+1)
  }

}
