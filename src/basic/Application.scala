package basic

object Application extends App {
  override def main(args: Array[String]): Unit = {
    Console.println("Welcome to the Simple Console, type exit or quit to leave")
    val console = new SimpleConsole()
    var done = false
    while(!done){
      Console.print("+> ")
      val input = readLine().toLowerCase
      if(input == "quit" || input == "exit"){
        done = true
      }else if(input == "help"){ 
    	  console.printOptions(input)
      }else if(input != ""){
        var programArgs = input split " "
        console.run(programArgs)
      }
    }
  }
}