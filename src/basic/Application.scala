package basic

object Application extends App {
  override def main(args: Array[String]): Unit = {
    Console.println("Welcome to the Simple Console, type exit or quit to leave")
    val console = new SimpleConsole()
    var done = false
    while(!done){
      Console.print("+> ")
      val input = readLine()
      var lowerInput = input.toLowerCase
      if(lowerInput == "quit" || lowerInput == "exit"){
        done = true
      }else if(lowerInput == "help"){ 
    	  console.printOptions(new Array[String](0))
      }else if(input != ""){
        var programArgs = input split " "
        console.run(programArgs)
      }
    }
  }
}