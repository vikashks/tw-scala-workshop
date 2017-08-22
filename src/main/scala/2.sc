import scala.collection.mutable

def square1(values: List[Int]): List[Int] = {
  val squares = mutable.Buffer.empty[Int]
  val size = values.size - 1
  for (i <- 0 to size) {
    val value = values(i)
    squares += value * value
  }
  squares.toList
}

def square2(values: List[Int]): List[Int] = {
  val squares = mutable.Buffer.empty[Int]
  values.foreach((value: Int) => squares += value * value)
  squares.toList
}

def square3(values: List[Int]): List[Int] = {
  values.map((value: Int) => value * value)
}

def square4(values: List[Int]): List[Int] = {
  val squares = for {
    value <- values
  } yield value * value
  squares
}

def square5(values: List[Int]): List[Int] = {
  values match {
    case (value: Int) :: values =>
      val value1 = value * value
      List(value1) ++ square5(values)
    case Nil => List.empty[Int]
  }
}