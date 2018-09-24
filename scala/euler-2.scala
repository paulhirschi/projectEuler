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
