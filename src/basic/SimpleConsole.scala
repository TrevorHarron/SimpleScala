package basic

import java.io.IOException
import scala.io.Source

class SimpleConsole() {

  def run(args: Array[String]): Unit = {
    if(args.length != 2){
      printError("invalid number of arguments")
      return
    }
    if(! (ops contains args(1))){
      printError("Invalid operation")
      return
    }
    try{
      ops(args(1)).func(args(0))
    } catch {
      case ex: IOException => {
        printError("Java IOException, please check the input file")
      }
      case ex: Exception =>{
        printError("Uknown Error Occured")
      }
    }

  }
     val ops = Map(
      "--help" -> new Ops("--help","Help: see all of the options for the program",printOptions _),
      "-h" -> new Ops("-h","Help: see all of the options for the program",printOptions _),
      "--line-count" -> new Ops("--line-count", "Line Count: count the number of lines in the file", countLines _),
      "--word-count" -> new Ops("--word-count", "Word Count: count the number of words in the file", countWords _) 
     )

  def printOptions(arg: String) {
    Console.println("Usage of application is: <file> <option>")
    for(key <- ops.keys){
      Console.printf("|\t%s\t%s\n", key,ops(key).description)
    }
  }
     
  def printError(msg: String) {
    Console.println("An error was encountered: "+msg)
    printOptions("")
  }
  
  def countLines(file:String){
    var source = Source.fromFile(file, "UTF-8")
    var count = source.getLines.length
    Console.printf("There are %d lines in the file %s\n", count, file)
  }
  
  def countWords(file:String){
    var source = Source.fromFile(file, "UTF-8")
    var lines = source.getLines
    var count = 0
    for(line <- lines){
      count += line.split(" ").length
    }
    Console.printf("There are %d words in the file %s\n", count, file)
  }

}