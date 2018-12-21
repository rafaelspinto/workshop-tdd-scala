package workshop.strings

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks

@RunWith(classOf[JUnitRunner])
class StringProcessorTest extends FunSuite with TableDrivenPropertyChecks {

  val stringProc = new StringProcessor()

  val dataWithVowels = Table(
    ("word", "expected"),
    ("abcd", 1),
    ("abcdde", 2)
  )

  val dataWithoutVowels = Table(
    ("wrd"),
    ("bcd"),
    ("bcdd")
  )

  test("countVowels: if vowels exist returns number of vowels") {
    forAll(dataWithVowels) { (word: String, expected: Int) =>
      assert(stringProc.countVowels(word) == expected)
    }
  }

  test("countVowels: if vowels dont exist returns 0") {
    forAll(dataWithoutVowels) { (word: String) =>
      assert(stringProc.countVowels(word) == 0)
    }
  }
}
