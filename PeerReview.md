***Shubham's Review***

#### Question-1:

```
package practice
import scala.collection.mutable.ArrayBuffer

object Ass1{

  def bucketize(numbers : List[Double]):ArrayBuffer[String]  = {
    val rangeofvals = Range.BigDecimal(0, 1, 0.050).toList
    val outputBucket = ArrayBuffer[String]()

    for(p <- numbers){
      //Extracting the number that is x than decimal value as dec x.yyy then finding the
      //bucket number
      val header = (p/1).toInt
      val dec = p%1
      val bucketnumber = math.ceil(dec/(0.049)).toInt

      //We are comparing it with the bucket it belongs to the
      val start : BigDecimal = if (bucketnumber != 0) header + rangeofvals(bucketnumber-1)  else header
      val startWithPrecision = start.setScale(3, BigDecimal.RoundingMode.HALF_UP)
      val end = start + 0.049
      val bucket = startWithPrecision.toString + " - " +  end.toString();

      //Append the bucket x.yyy - x.yyy + 0.049
      outputBucket.append(bucket)

    }
    return outputBucket
  }

  def main(args: Array[String]): Unit = {

    val numbers = List(12.05, 12.03,10.33, 11.45, 13.00)
    val origBuckets = bucketize(numbers)
    print("[")
    for(p <- origBuckets) {
      print(s"${p}, ")
    }
    print("]")
  }
}
```
1.)At first he broke the interval into buckets.

2.)Then he traversed the whole list.

3.)Then we find the header and digits after decimal.

4.)We then find in which bucket the number is falling.

#### Question-2:

##### Task-1:
Sorted the list in descending order based on the runs scored by the players using sortby function and then top player instance is taken by using the take function.

##### Task-2:
Sorted the list in descending order based on the runs scored by the players using sortby function and then the top 5 players' instances are taken by using the take function.

##### Task-3:
Sorted the list in descending order based on the wickets taken by the players using sortby function and then the top 5 players' instances are taken by using the take function.

##### Task-4:
Sorted the list in descending order based on the performance taken by the players using sortwith function and then the rank of players is printed by a user-defined function.
