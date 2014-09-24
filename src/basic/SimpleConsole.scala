package basic

class SimpleConsole() {

  def run(args: Array[String]): Unit = {
    if(args.length != 2){
      printError("invalid number of arguments")
      return
    } else {
      Console.println("Bravo! you passed in the correct number of arguments!")
    }
    if(! (ops contains args(1))){
      printError("Invalid operation")
      return
    }
    if(args(1) == "-h" || args(1) == "--help" ){ ops("-h").func }

  }
     val ops = Map(
      "--help" -> new Ops("--help","Help: see all of the options for the program",printOptions _),
      "-h" -> new Ops("-h","Help: see all of the options for the program",printOptions _)
      )

  def printOptions(arg: String = "") {
    Console.println("Usage of application is: <file> <option>")
    for(key <- ops.keys){
      Console.printf("|\t%s\t%s\n", key,ops(key).description)
    }
  }
  def printError(msg: String) {
    Console.println("An error was encountered: "+msg)
    printOptions()
  }

}