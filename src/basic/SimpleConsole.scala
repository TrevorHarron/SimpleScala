package basic

import scala.io.Source

import java.io.IOException

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
      "-h" -> new Ops("-h","Help: see all of the options for the program",printOptions _)
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

}