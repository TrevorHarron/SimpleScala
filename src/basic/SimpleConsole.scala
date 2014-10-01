package basic

import java.io.IOException
import scala.io.Source
import scala.util.{Success, Failure}
class SimpleConsole() {

  def run(args: Array[String]): Unit = {
    if(args.length < 2){
      printError("invalid number of arguments")
      return
    }
    if(! (ops contains args(1))){
      printError("Invalid operation")
      return
    }
    try{
      var aArgs = new Array[String](args.length)
      aArgs + args.head
      if(args.size > 2){
    	  aArgs zip args.slice(2, args.length)
      }
      ops(args(1)).func(aArgs)
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
      "--line-count" -> new Ops("--line-count", "Line Count: count the number of lines in the file", countLines _),
      "--word-count" -> new Ops("--word-count", "Word Count: count the number of words in the file", countWords _),
      "--character-count" -> new Ops("--character-count", "Character Count: count the number of total characters in the file", countCharacters _),
      "--is-empty" -> new Ops("--is-empty","Is Empty: checks to see if the file exists but is empty",isEmpty _),
      "--whitespace-count"-> new Ops("--whitespace-count", "Counts the number of white space characters", _ => Console.println("Not Implemented."))
     )

  def printOptions(arg: Array[String]) {
    Console.println("Usage of application is: <file> <option>")
    for(key <- ops.keys){
      Console.printf("|\t%s\t%s\n", key,ops(key).description)
    }
  }
     
  def printError(msg: String) {
    Console.println("An error was encountered: "+msg)
    printOptions(new Array[String](1))
  }
  
  def countLines(args:Array[String]){
    val file =  args(0)
    var source = Source.fromFile(file, "UTF-8")
    var count = source.getLines.length
    Console.printf("There are %d lines in the file %s\n", count, file)
  }
  
  def countWords(args:Array[String]){
    val file =  args(0)
    var source = Source.fromFile(file, "UTF-8")
    var lines = source.getLines
    var count = 0
    for(line <- lines){
      count += line.split(" ").length
    }
    Console.printf("There are %d words in the file %s\n", count, file)
  }
  
    
  def countCharacters(args:Array[String]){
    val file =  args(0)
    var source = Source.fromFile(file, "UTF-8")
    var lines = source.getLines
    var count = 0
    for(line <- lines){
      count += line.split("").length
    }
    Console.printf("There are %d characters in the file %s\n", count, file)
  }
  
  def isEmpty(args:Array[String]){
    val file = args(0)
    var source = Source.fromFile(file, "UTF-8")
    var lines = source.getLines
    if(lines.isEmpty)
      Console.println("This is an empty file.")
    else
      Console.println("The file is not empty.")
  }

}