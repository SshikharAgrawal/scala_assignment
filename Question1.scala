package training_practice
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readInt
import scala.io.StdIn.readDouble

object Question{
  def bucketiser(n : Double): String = {
    val temp =(n*1000)%100

    if(temp < 50 ){
      val left = n - (temp/1000)
      val right = n + (49 - temp)/1000
      val res = f"$left%,.3f" + " - " + f"$right%,.3f"
      return res
    }
    else{
      val left = n - (temp/1000)+0.050
      val right = n + (99-temp)/1000
      val res = f"$left%,.3f" + " - " + f"$right%,.3f"
      return res
    }
  }


}
object Question1  {
  def main(args : Array[String])={
    val n : Int =  readInt()
    var result = ArrayBuffer[String]()
    for(i <- 0 until n){
      val input_ = readDouble()
      result += Question.bucketiser(input_)
    }
    println(result)
  }
}