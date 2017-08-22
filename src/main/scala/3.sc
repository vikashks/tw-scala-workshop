

def merge(a: Option[String], b: Option[String]): Option[String] = {
  (a, b) match {
    case (Some(x), Some(y)) => Some(x + y)
    case (None, _) => b
    case (_, None) => a
  }
}


merge(Some("abc"), Some("def"))


/*sealed trait List[T]

case class Cons[T](head: T, tail: List[T]) extends List[T]
case class ::[T](head: T, tail: List[T]) extends List[T]

case class Nil[T]() extends List[T]

List(1, 2, 3)*/


def reverse[T](xs: List[T], accumulator: List[T]): List[T] = {
  xs match {
    case Nil => accumulator
    case head :: tail => reverse(tail, head :: accumulator)
  }
}

reverse(List(1, 2, 3), Nil)


sealed trait J

case object JNull extends J{
  override def toString: String = null
}

case class Record(key: String, values: J*) {
  override def toString: String = key + ":" + values.map(_.toString).mkString("")
}

case class JValue[T](value: T) extends J {
  override def toString: String = value.asInstanceOf[T].toString
}

case class JObject(records: Record*) extends J {
  override def toString: String =
    "{" + records.map((record: Record) => record.toString).mkString(",") + "}"
}

case class JArray[T](values: J*) extends J {
  override def toString: String =
    "[" + values.map((value: J) => {
      value match {
        case jObject: JObject => jObject.toString
        case _ => value.toString
      }
    }).mkString(",") + "]"
}


val name1 = Record("name", JValue("Vicky"))
val dsg1 = Record("designation", JValue("Dev"))
val record1 = JObject(name1, dsg1)
val name2 = Record("name", JValue("Vicky1"))
val dsg2 = Record("designation", JValue("Dev1"))
val record2 = JObject(name2, dsg2)


val data = JObject(Record("data", JArray(record1,record2)), Record("test", JValue(JNull)))




