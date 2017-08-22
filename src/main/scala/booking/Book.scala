package booking

case class Book(hotels: Seq[Hotel])


object Book {


  def book(customer: Customer, weekend: Int, weekday: Int, book: Book): Unit = {
    var traiff = 0.0
    book.hotels.foreach((hotel: Hotel) => {
      val tempTraiff = Hotel.tariff(hotel, weekend, weekday)
      if (traiff == tempTraiff) {
        traiff = Hotel.tariff(bestHotel(Hotel(Star(1), 0, 0), book.hotels), weekend, weekday)
      }
    })
  }


  def bestHotel(hotel: Hotel, hotels: Seq[Hotel]): Hotel = {
    if (hotels.nonEmpty) {
      if (hotel == null) bestHotel(hotels.head, hotels.tail)
      else if (hotel.star.compare(hotels.head)) {
        bestHotel(hotel, hotels.tail)
      } else {
        bestHotel(hotels.head, hotels.tail)
      }
    }
    hotel
  }
}
