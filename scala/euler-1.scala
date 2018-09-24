/*

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

*/

val a: List[Int] = 1 until 1000 toList

def isMultiple(n: Int): Boolean =
  n % 3 == 0 || n % 5 == 0

def problem(limit: Int, mod1: Int, mod2: Int): Int = {
  // List.range(1, limit) filter(n => n % mod1 == 0 || n % mod2 == 0) sum
  // val a = for {
  //   x <- 1 until 1000
  //   if isMultiple(x)
  // } yield x
  // a sum
  @scala.annotation.tailrec
  def go(limit: Int, current: Int, accum: Int, f: Int => Boolean): Int = {
    if (current >= limit) accum
    else {
      val newAccum = if (f(current)) current + accum else accum
      go(limit, current + 1, newAccum, f)
    }
  }

  go(limit, 1, 0, isMultiple)

}

val eulerOne: Int => Int => Int => Int =
  limit => mod1 => mod2 => {
    List.range(1, limit) filter(n => n % mod1 == 0 || n % mod2 == 0) sum
  }

// println(a.filter(isMultiple).sum)
println(problem(1000, 3, 5))
// println(eulerOne(1000)(3)(5))
