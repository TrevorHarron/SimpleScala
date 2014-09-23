
object Application extends App {
  private val BLANK = ""
  override def main(args: Array[String]): Unit = {
      
    Console.print(args.length+" argument(s) were passed in.")
    
    
  }
  val ops = Map(
      "--help" -> new Ops("--help","Help: see all of the options for the program",printOptions _),
      "-h" -> new Ops("-h","Help: see all of the options for the program",printOptions _))
  
  def printOptions(arg: String = BLANK) {
    Console.println("Usage of application is: Application <file> <flag>")
    for(key <- ops.keys){
      Console.printf("|\t{0}\t{1}", key,ops(key).description)
    }
  }
  def printError(msg: String){
    Console.println("An error was encountered: "+msg)
    printOptions _
  }
}