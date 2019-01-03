package workshop.service

import org.junit.runner.RunWith
import org.scalatest.AsyncFunSuite
import org.scalatest.junit.JUnitRunner
import workshop.strings.EmptyStringException

import scala.concurrent.Future

@RunWith(classOf[JUnitRunner])
class TranslateServiceTest extends AsyncFunSuite {

  test("call: if hello is given returns ola") {
    val translate = new TranslateService()
    val futureResponse: Future[String] = translate.call("hello")

    futureResponse map { res => assert(res == "ola")}
  }

  test("call: if empty string is given throws EmptyStringException") {
    val translate = new TranslateService()
    val futureResponse: Future[String] = translate.call("")

    recoverToSucceededIf[EmptyStringException] {
      futureResponse
    }
  }
}
