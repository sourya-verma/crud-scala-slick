import slick.jdbc.MySQLProfile.api._
import java.sql.Date


final case class University(id: Int, name: String, location: String)

final class UniversityTable(tag: Tag) extends Table[University](tag, "university") {
  def uni_id = column[Int]("uni_id", O.PrimaryKey)
  def name = column[String]("name")
  def location = column[String]("location")
  override def * = (uni_id, name, location).mapTo[University]
}

