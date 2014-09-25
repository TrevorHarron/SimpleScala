package basic

import scala.io.Source

trait OpsFunction extends Function[String,Unit] {
	
	def apply(arg:String): Unit = {
	  var source = Source.fromFile(arg, "UTF-8")
	  var lines = source.getLines
	  for(line <- lines){
	    println(line)
	  }
	}
	
}