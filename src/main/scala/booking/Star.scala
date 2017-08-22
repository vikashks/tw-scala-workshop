package booking


case class Star(value: Int) {
  def compare(hotel: Hotel): Boolean = value > hotel.star.value

}

object Star {

  def apply(star: Int): Star = {
    if (star < 1 && star > 5)
      throw new Exception("Invalid star, range should be from 1 to 5")
    new Star(star)
  }

}
