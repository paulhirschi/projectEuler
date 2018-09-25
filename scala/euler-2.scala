/*

Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

*/

def evenSum(max: Int): Long = {

  def go(max: Int, prev: Int, curr: Int, acc: Long): Long = {
    val nextFib = prev + curr
    if (nextFib > max) acc
    else {
      val newAccum = if (nextFib % 2 == 0) acc + nextFib else acc
      go(max, curr, nextFib, newAccum)
    }
  }

  go(max, 0, 1, 0)

}

println(evenSum(4000000))
