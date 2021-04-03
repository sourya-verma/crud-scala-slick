//import Main.student

import slick.jdbc.MySQLProfile.api._
import TableObject._
import Student._
import University._

import java.sql.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Main extends App {
  val db = Database.forConfig("mydb")

  //      def createTableConnection (): Unit = {
  //        db.run(university.schema.create)
  //        db.run(student.schema.create)
  //      }
  def createUniversity(uni: University) = {
    val action = db.run(university += uni)
    val l = action.onComplete {
      case Success(value) => value
      case Failure(err) => err
    }

  }

  def createStudent(stu: Student)= {

    val action = db.run(student += stu)
    action.onComplete {
      case Success(value) => value
      case Failure(err) => err
    }
  }

  def readAllStudent() = {
    db.run(student.result).foreach(element => { // printing
      element.foreach(println)
    })
    db.run(student.result).onComplete{
      case Success(value) => println(value)

    }

  }

  def readAllUniversity() = {
    db.run(university.result).foreach(element => { // printing
      element.foreach(println)
    })


  }

  def updateStudent(stu: Student, sid: Int) = {
    val updatedResult = student.filter(_.id === sid).update(stu)
    val result = db.run(updatedResult)
    result.onComplete {
      case Success(value) => println(value)
      case Failure(err) => err.printStackTrace()
    }

  }

  def updateUniversity(uni: University, uid: Int) = {
    val updatedResult = university.filter(_.uni_id === uid).update(uni)
    val result = db.run(updatedResult)
    result.onComplete {
      case Success(value) =>println(value)
      case Failure(err) => err.printStackTrace()
    }

  }

  def deleteStudent(sid: Int) = {
    val updatedResult = student.filter(_.id === sid).delete
    val result = db.run(updatedResult)
    result.onComplete {
      case Success(value) =>println(value)
      case Failure(err) => err.printStackTrace()
    }

  }


  def deleteUniversity(uid: Int) = {
    val updatedResult = student.filter(_.id === uid).delete
    val result = db.run(updatedResult)
    result.onComplete {
      case Success(value) =>println(value)
      case Failure(err) => err.printStackTrace()
    }

  }

  def getStudentUniversityName(): Unit = {
    val action = (for {
      (stu, uni) <- student join university on (_.universityId === _.uni_id)
    } yield (stu.name, uni.name))
    db.run(action.result).onComplete {
      case Success(value) => println(value)
      case Failure(err) => err.printStackTrace()
    }
    db.run(action.result).onComplete {
      case Success(value) =>println(value)
      case Failure(err) => err.printStackTrace()
    }



  }

  def getUniversityStudentCount() = {
    val ans = (for {
      (s, u) <- student join university on (_.universityId === _.uni_id)
    } yield (s, u)).groupBy(_._2.name).map {
      case (uni, data) => (uni, data.map(_._1.id).length)
    }
    db.run(ans.result).onComplete {
      case Success(value) => println(value)
      case Failure(err) => err.printStackTrace()
    }


  }


//    createStudent(Student(0, "a", "a.k@techsophy.com", 13, java.sql.Date.valueOf("1997-06-06")))
  //  createStudent(Student(0, "b", "b.k@techsophy.com", 13, java.sql.Date.valueOf("1997-06-06")))
  //  createStudent(Student(0, "c", "c.k@techsophy.com", 12, java.sql.Date.valueOf("1997-06-06")))
  //  createStudent(Student(4, "d", "d.k@techsophy.com", 12, java.sql.Date.valueOf("1997-06-06")))
  //  createStudent(Student(5, "e", "e.k@techsophy.com", 11, java.sql.Date.valueOf("1997-06-06")))
  //
    println(createUniversity(University(11, "HCU", "hcu@tgmail.com")))
  //  createUniversity(University(12, "NIT", "nit@tgmail.com"))
//  createUniversity(University(16, "PSG", "psg@tgmail.com"))


  //  readAllUniversity()
  //   readAllStudent()
  //  updateStudent(Student(1, "z", "z.tech", 13, Date.valueOf("1997-07-21")), 1)
  //  deleteStudent(3)
  //  getStudentUniversityName()
  //  getUniversityStudentCount()
  Thread.sleep(4000)
}



