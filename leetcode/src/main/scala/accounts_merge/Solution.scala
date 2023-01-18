package accounts_merge

import scala.collection.mutable

object Solution extends App {
//  println(accountsMerge(List[List[String]](List[String]("John", "johnsmith@mail.com", "john_newyork@mail.com"), List[String]("John", "johnsmith@mail.com", "john00@mail.com")
//    , List[String]("Mary", "mary@mail.com"), List[String]("John", "johnnybravo@mail.com"))))

  println(accountsMerge(List[List[String]](List[String]("David","David0@m.co","David1@m.co"), List[String]("David","David3@m.co","David4@m.co"),
    List[String]("David","David4@m.co","David5@m.co"), List[String]("David","David2@m.co","David3@m.co"), List[String]("David","David1@m.co","David2@m.co"))))
//
//  println(accountsMerge(List[List[String]](List[String]("Isa","Isa4@m.co","Isa36@m.co","Isa37@m.co","Isa38@m.co","Isa39@m.co","Isa40@m.co","Isa41@m.co","Isa42@m.co","Isa43@m.co"),List[String]("Isa","Isa6@m.co","Isa54@m.co","Isa55@m.co","Isa56@m.co","Isa57@m.co","Isa58@m.co","Isa59@m.co","Isa60@m.co","Isa61@m.co"),List[String]("Isa","Isa1@m.co","Isa9@m.co","Isa10@m.co","Isa11@m.co","Isa12@m.co","Isa13@m.co","Isa14@m.co","Isa15@m.co","Isa16@m.co"),List[String]("Isa","Isa4@m.co","Isa36@m.co","Isa37@m.co","Isa38@m.co","Isa39@m.co","Isa40@m.co","Isa41@m.co","Isa42@m.co","Isa43@m.co"),List[String]("Isa","Isa7@m.co","Isa63@m.co","Isa64@m.co","Isa65@m.co","Isa66@m.co","Isa67@m.co","Isa68@m.co","Isa69@m.co","Isa70@m.co"),List[String]("Isa","Isa10@m.co","Isa90@m.co","Isa91@m.co","Isa92@m.co","Isa93@m.co","Isa94@m.co","Isa95@m.co","Isa96@m.co","Isa97@m.co"),List[String]("Isa","Isa3@m.co","Isa27@m.co","Isa28@m.co","Isa29@m.co","Isa30@m.co","Isa31@m.co","Isa32@m.co","Isa33@m.co","Isa34@m.co"),List[String]("Isa","Isa7@m.co","Isa63@m.co","Isa64@m.co","Isa65@m.co","Isa66@m.co","Isa67@m.co","Isa68@m.co","Isa69@m.co","Isa70@m.co"),List[String]("Isa","Isa5@m.co","Isa45@m.co","Isa46@m.co","Isa47@m.co","Isa48@m.co","Isa49@m.co","Isa50@m.co","Isa51@m.co","Isa52@m.co"),List[String]("Isa","Isa0@m.co","Isa0@m.co","Isa1@m.co","Isa2@m.co","Isa3@m.co","Isa4@m.co","Isa5@m.co","Isa6@m.co","Isa7@m.co"),List[String]("Isa","Isa0@m.co","Isa0@m.co","Isa1@m.co","Isa2@m.co","Isa3@m.co","Isa4@m.co","Isa5@m.co","Isa6@m.co","Isa7@m.co"),List[String]("Isa","Isa2@m.co","Isa18@m.co","Isa19@m.co","Isa20@m.co","Isa21@m.co","Isa22@m.co","Isa23@m.co","Isa24@m.co","Isa25@m.co"),List[String]("Isa","Isa9@m.co","Isa81@m.co","Isa82@m.co","Isa83@m.co","Isa84@m.co","Isa85@m.co","Isa86@m.co","Isa87@m.co","Isa88@m.co"),List[String]("Isa","Isa6@m.co","Isa54@m.co","Isa55@m.co","Isa56@m.co","Isa57@m.co","Isa58@m.co","Isa59@m.co","Isa60@m.co","Isa61@m.co"),List[String]("Isa","Isa11@m.co","Isa99@m.co","Isa100@m.co","Isa101@m.co","Isa102@m.co","Isa103@m.co","Isa104@m.co","Isa105@m.co","Isa106@m.co"),List[String]("Isa","Isa0@m.co","Isa0@m.co","Isa1@m.co","Isa2@m.co","Isa3@m.co","Isa4@m.co","Isa5@m.co","Isa6@m.co","Isa7@m.co"),List[String]("Isa","Isa5@m.co","Isa45@m.co","Isa46@m.co","Isa47@m.co","Isa48@m.co","Isa49@m.co","Isa50@m.co","Isa51@m.co","Isa52@m.co"),List[String]("Isa","Isa2@m.co","Isa18@m.co","Isa19@m.co","Isa20@m.co","Isa21@m.co","Isa22@m.co","Isa23@m.co","Isa24@m.co","Isa25@m.co"),List[String]("Isa","Isa3@m.co","Isa27@m.co","Isa28@m.co","Isa29@m.co","Isa30@m.co","Isa31@m.co","Isa32@m.co","Isa33@m.co","Isa34@m.co"),List[String]("Isa","Isa1@m.co","Isa9@m.co","Isa10@m.co","Isa11@m.co","Isa12@m.co","Isa13@m.co","Isa14@m.co","Isa15@m.co","Isa16@m.co"))))

  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val resultList = mutable.ListBuffer[(String, mutable.Set[String])]()
    for (account <- accounts) {
      var isFind = false
      var i = 1
      val tmpSet = mutable.Set[String]()
      var indexTmp = mutable.ListBuffer[Int]()
      while (i < account.length) {
        for (j <-0 until  resultList.length) {
          if (resultList(j)._2.contains(account(i))) {
            isFind = true
            if(!indexTmp.contains(j)){
              indexTmp.append(j)
            }
          }
        }
        if(!isFind){
          tmpSet.add(account(i))
        }
        i += 1
      }

      indexTmp = indexTmp.sortBy(i=>i)
//      println(s"index=$indexTmp")
      if (isFind) {
        account.splitAt(1)._2.foreach(tmpSet.add)
        indexTmp.foreach(resultList(_)._2.foreach(tmpSet.add(_)))
        resultList(indexTmp(0)) = (resultList(indexTmp(0))._1, tmpSet)
        for(i<- indexTmp.length-1 to 1 by -1){
          println(i)
          resultList.remove(indexTmp(i))
        }
      }else{
        resultList.append((account(0),tmpSet))
      }
//      println(s"$resultList,$indexTmp")

    }

    resultList.map(i => {
      val tmp = mutable.ListBuffer[String](i._1)
      i._2.toList.sortBy(a=>a).foreach(b=>tmp.append(b))
      tmp.toList
    }).toList
  }
}
