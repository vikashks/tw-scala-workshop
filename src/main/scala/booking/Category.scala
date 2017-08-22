package booking

sealed trait Category

object Category {

  case object Regular extends Category

  case object Reward extends Category

}

