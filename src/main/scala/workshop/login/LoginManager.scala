package workshop.login

import workshop.strings.EmptyPasswordException

import scala.collection.immutable.HashMap


class LoginManager(
                    val userRepo: HashMap[String, String]
                  ) {
  def login(username: String, password: String): Boolean = {
    if (password.isEmpty) {
      throw new EmptyPasswordException
    }
    if (!userRepo.contains(username) || userRepo.get(username) != Some(password)) {
      throw new InvalidCredentialsException
    }
    true
  }
}
