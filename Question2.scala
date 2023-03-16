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