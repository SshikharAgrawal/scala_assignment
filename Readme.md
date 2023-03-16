**Question1**

Here this program takes an array of doubles and groups them into buckets based on a specified range interval.The range interval is defined as (x, x+0.049), so for example, the first bucket would be from 0.000 to 0.049, the second bucket would be from 0.050 to 0.099, and so on. 

```package training_practice
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
```
Here in the Question object we at first see the digits after the decimal and then we chose the left and right limits of the double value if the value is less than 50 we push it to one type of bucket else another one.


**Question2**
In this question we were asked to write 4 queries and get the desired results.
```
package training_practice
import scala.collection.mutable.ArrayBuffer

case class Player(Year : Int, PlayerName : String, Country : String, Matches : Int, Runs: Int, Wickets : Int){
  def print_player(): Unit = {
    println("Year:- " + this.Year + " PlayerName:- " + this.PlayerName + " Country:- " + this.Country + " Matches:- " + this.Matches
      + " Runs:- " + this.Runs + " Wickets:- " + this.Wickets)
  }
  def print_player_rank(): Unit = {
    println("Year:- " + this.Year + " PlayerName:- " + this.PlayerName + " Country:- " + this.Country + " Matches:- " + this.Matches
      + " Runs:- " + this.Runs + " Wickets:- " + this.Wickets + " Performance:- " + (this.Wickets * 5 + (5 * this.Runs).toDouble/100))
  }
}

object questions{
  def question01( input_ : List[Player]) = {
    print("Player with highest number of Runs:- ")
    val first = (input_.sortBy(_.Runs)(Ordering[Int].reverse).take(1))
    for (x <- first) {
      x.print_player()
    }
    println()
  }

  def question02(input_ : List[Player]) = {

    val second = input_.sortBy(_.Runs)(Ordering[Int].reverse).take(5)
    println("Top 5 players runs scored:- ")
    for (x <- second) {
      x.print_player()
    }
    println()
  }

  def question03(input_ : List[Player]) = {
    val third = input_.sortBy(_.Wickets)(Ordering[Int].reverse).take(5)
    println("Top 5 players wickets taken:- ")
    for (x <- third) {
      x.print_player()
    }
    println()
  }

  def question04(input_ : List[Player]) = {

    val fourth = input_.sortWith((a, b) => a.Wickets * 5 + (5 * a.Runs).toDouble / 100 > b.Wickets * 5 + (5 * b.Runs) / 100)
    println("Players with overall performance:- ")
    var count = 1
    for (x <- fourth) {
      print("Rank:- " + count + " ")
      count += 1
      x.print_player_rank()
    }
    println()
  }
}
object Question2 {
  def main(args: Array[String]) = {
    var input_ =List(
      Player(2021, "Sam", "India", 23, 2300, 3),
      Player(2021, "Ram", "India", 23, 300, 30),
      Player(2021, "Mano", "India", 23, 300, 13),
      Player(2021, "Shyam", "India", 23, 407, 14),
      Player(2021, "Vaibhav", "India", 26, 608, 16),
      Player(2021, "Tushar", "India", 23, 208, 20),
    )
    // calling methods of different quieries.
    questions.question01(input_)
    questions.question02(input_)
    questions.question03(input_)
    questions.question04(input_)


  }
}
```
Initially, we created a case class named Player which holds details of players like a year, player name, country, matches, runs, and wickets.For printing the instance of the class print functions are created named print_player and print_player_rank.Instances of the players are created and appended to the list.

*In the first query there asked me to print the player with the best highest runs scored. For this, I sort the list in descending order based on the runs scored by the players using sortby function and then top player instance is taken by using the take function.

*In the second query there asked me to print the top 5 players' runs scored. For this, I sort the list in descending order based on the runs scored by the players using sortby function and then the top 5 players' instances are taken by using the take function.

*The third query asked me to print the top 5 players' wickets taken. For this, I sort the list in descending order based on the wickets taken by the players using sortby function and then the top 5 players' instances are taken by using the take function.

*In the fourth query there asked me to rank players with the overall performance given by some weight. For this, I sort the list in descending order based on the performance taken by the players using sortwith function and then the rank of players is printed by a user-defined function.


