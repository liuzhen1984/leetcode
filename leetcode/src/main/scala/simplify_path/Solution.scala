package simplify_path

import scala.collection.mutable

object Solution extends App {

  println(simplifyPath("/home/"))
  println(simplifyPath("/../"))
  println(simplifyPath("/home//fool/"))
  println(simplifyPath("/...//fool./"))
  println(simplifyPath("/...//fool..."))
  println(simplifyPath("/a/./b/../../c/"))
  println(simplifyPath("/a//b////c/d//././/.."))
  def simplifyPath(path: String): String = {
    /**
    '.' refers to current dir
        '..' refers to parent dir
        '//' treated as a single slash
        any other number of periods is a directory/file name

        canonical path:
        1. starts with '/'
        2. all directories are separated by a single slash '/'
        3. path does not end with '/'
        4. path only contains the directories on the path from the root direcotry to the target file or directory ( no relative path )
     */

    val pathComponents = path.split("/")

    case class CurrentPath(pathComponents: Vector[String])

    val resolvedPathComponents = pathComponents.drop(1).foldLeft(CurrentPath(Vector.empty)) { case (acc, cur) =>
      cur match {
        case "" => acc
        case "." => acc
        case ".." => CurrentPath(acc.pathComponents.dropRight(1))
        case other => CurrentPath(acc.pathComponents :+ other)
      }
    }

    resolvedPathComponents.pathComponents.mkString("/", "/", "")

  }
  def simplifyPath2(path: String): String = {
    val splitPath = path.split("/")
    var canonicalPath = mutable.ListBuffer[String]()
    for(file<-splitPath){
      file match {
        case "." => {}
        case "" => {}
        case ".." => if(canonicalPath.size>0) canonicalPath.remove(canonicalPath.length-1)
        case _ => canonicalPath.append(file)
      }
    }
    canonicalPath.mkString("/", "/", "")
  }

  def simplifyPath3(path: String): String = {
    var canonicalPath = mutable.ListBuffer[String]()
    var currentFile = ""

    def parserPath(current: String): Unit = {
      if (current == "..") {
        if(canonicalPath.size>0){
          canonicalPath.remove(canonicalPath.length-1)
        }
      } else {
        if (current != "" && current != ".") {
          canonicalPath.append(current)
        }
      }
    }
    for (i <- path) {
      i match {
        case '/' => {
          parserPath(currentFile)
          currentFile = ""
        }
        case _ => {
          currentFile = currentFile + i.toString
        }
      }
    }

    if(currentFile!=""){
      parserPath(currentFile)
    }
    canonicalPath.mkString("/","/","")
  }


}
