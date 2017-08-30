import java.time.LocalDateTime

import com.twitter.algebird.Aggregator

case class TestClass(id: Int, date: LocalDateTime)

object Test extends App {

  val orders = List(
    TestClass(1, LocalDateTime.of(2005, 12, 22, 0, 0, 0)),
    TestClass(2, LocalDateTime.of(2005, 8, 10, 0, 0, 0))
  )

  private implicit val localDateOrdering: Ordering[LocalDateTime] = Ordering.by(_.toLocalDate.toEpochDay)

  val minOp = Aggregator.minBy[LocalDateTime, LocalDateTime](identity)
    .composePrepare[TestClass](_.date)

}
