import slick.jdbc.MySQLProfile.api._
object TableObject {
  lazy val student = TableQuery[StudentTable]
  lazy val university = TableQuery[UniversityTable]
}
