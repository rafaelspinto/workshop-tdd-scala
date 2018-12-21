package workshop.login

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import workshop.strings.EmptyPasswordException

import scala.collection.immutable.HashMap

@RunWith(classOf[JUnitRunner])
class LoginManagerTest extends FunSuite {

  val userRepo: HashMap[String, String] = HashMap(("myuser", "mypassword"))
  val loginManager = new LoginManager(userRepo)

  test("login: if credentials are valid returns true") {
    val username = "myuser"
    val password = "mypassword"
    assert(loginManager.login(username, password))
  }

  test("login: credentials are invalid throws InvalidCredentialsException") {
    val username = "myuser"
    val password = "invalidpassword"
    assertThrows[InvalidCredentialsException] {
      loginManager.login(username, password)
    }
  }

  test("login: if password is empty throws EmptyPasswordException") {
    val username = "myuser"
    assertThrows[EmptyPasswordException] {
      loginManager.login(username, "")
    }
  }
}
