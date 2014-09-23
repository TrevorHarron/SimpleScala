
object Application extends App {
    override def main(args: Array[String]): Unit = {
      
    Console.print(args.length+" argument(s) were passed in.")
    
    
  }
  val options = Map(
      "--help" -> new Ops("--help","Help: see all of the options for the program",printOptions("")),
      "-h" -> new Ops("-h","Help: see all of the options for the program",printOptions("")))
  
  def printOptions(arg: String) {
    Console.println("Usage of application is: Application <file> <flag>")
    for(key <- options.keys){
      Console.printf("|\t{0}", key)
    }
  }
  def printError(msg: String){
    Console.println("An error was encountered: "+msg)
    printOptions("")
  }
}