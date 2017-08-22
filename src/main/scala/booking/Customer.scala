package booking


case class Customer(category: Category) {
  def isRewardCustomer: Boolean = category == Category.Reward
}
