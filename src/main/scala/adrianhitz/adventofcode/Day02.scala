package adrianhitz.adventofcode

object Day02 extends AdventIO {
  override def main(args: Array[String]): Unit = {
    write1(part1.toString)
    write2(part2.toString)
  }

  // Golf: 133 bytes
  def part1(implicit s: String): Int = {
    var a, b = 0
    for(l <- s.split('\n')) {
      def f(x: Int) = l.foldLeft(false)((i, c) => if(l.count(_ == c) == x) true else i)

      if(f(2)) a += 1
      if(f(3)) b += 1
    }
    a * b
  }

  // Golf: 112 bytes
  def part2(implicit s: String): String = {
    val t = s.split('\n')
    for(a <- t)
      for(b <- t) {
        var s = ""
        for(i <- 0 to 25) if(a(i) == b(i)) s += a(i)
        if(s.length == 25) return s
      }
    s
  }
}