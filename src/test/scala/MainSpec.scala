import org.scalatest._
import funsuite._
import java.sql.Date
import Main._
class MainSpec extends AnyFunSuite {
    test("insertion in student table") {
        assert(createUniversity(University(12, "a", "v")) != None)
    }



}
