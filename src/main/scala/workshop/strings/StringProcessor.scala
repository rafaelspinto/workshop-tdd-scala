package workshop.strings

class StringProcessor() {
  def countVowels(str: String) = {
    if (str.isEmpty) {
      throw new EmptyStringException
    }
    var count = 0
    val vowels = "aeiouAEIOU"
    for (char <- str.toCharArray) {
      if (vowels.contains(char)) count += 1
    }
    count
  }
}
