
def perform[ResultType,ElementType](values: List[ElementType], seed: ResultType)
                       (f: (ResultType, ElementType) => ResultType): ResultType = {
  val iterator = values.iterator
  var total = seed
  while (iterator.hasNext) {
    total = f(total, iterator.next())
  }
  total
}

def perform[ElementType](xs: List[ElementType], f: ElementType => ElementType): List[ElementType] = {
  var result = List.empty[ElementType]
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = f(iterator.next()) :: result
  }
  result.reverse
}


perform[Int,Int](List(1, 2, 3, 4), 0)((x: Int, y: Int) => x + y)
perform[String,Int](List(1, 2, 3, 4), "")((x: String, y: Int) => x+ y)
perform[Int](List(1, 2, 3, 4), (x: Int) => x * x)



