import TableObject._
import slick.jdbc.MySQLProfile.api._
import java.sql.Date

final case class Student(id: Int, name: String, email: String, university_id: Int, dob: Date)

class StudentTable(tag: Tag) extends Table[Student](tag, "student") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name")

  def email = column[String]("email")

  def universityId = column[Int]("uni_id")

  def dob = column[Date]("dob")

  def university_foreign = foreignKey("uni_id", universityId, university)(_.uni_id)

  override def * = (id, name, email, universityId, dob).mapTo[Student]
}
