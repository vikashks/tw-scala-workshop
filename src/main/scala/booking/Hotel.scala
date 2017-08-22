package booking


case class Hotel(star: Star, weekendRate: Double, weekdayRate: Double)

object Hotel {
  def tariff(hotel: Hotel, weekend: Int, weekday: Int): Double = {
    weekend * hotel.weekendRate + weekday * hotel.weekdayRate
  }



}
