package q1

object question1 {

  def encryptfunction(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val shiftMod = shift % 26
        val offset = if (char.isLower) 'a' else 'A'
        ((char - offset + shiftMod) % 26 + offset).toChar
      } else {
        char
      }
    }.mkString
  }

  def decryptfunction(text: String, shift: Int): String = {
    encryptfunction(text, -shift)
  }

  def cipherfunction(text: String, shift: Int, operation: (String, Int) => String): String = {
    operation(text, shift)
  }


  def main(args:Array[String]): Unit = {

    val plaintext = "Hello, World!"
    val shift = 3

    val encryptedText = cipherfunction(plaintext, shift, encryptfunction)
    println(s"Encrypted: $encryptedText")

    val decryptedText = cipherfunction(encryptedText, shift, decryptfunction)
    println(s"Decrypted: $decryptedText")
  }
}