package workshop.service

import workshop.strings.EmptyStringException

import scala.concurrent.{ExecutionContext, Future}

class TranslateService() {
  def call(str: String)(implicit e:ExecutionContext): Future[String] = Future{
   str match {
     case "hello" => "ola"
     case "" => throw new EmptyStringException
   }
  }
}
