
fun printSum(vararg numbers: Int) {
  val sum = numbers.sum()
  print(sum)
}

printSum(1, 2, 3, 4, 5) // 15
printSum() // 0

fun printAll(vararg texts: String) {
  // texts의 유추된 형식은 Array<String>이다.
  val allTexts = texts.joinToString(",")
  println("$allTexts")
}
printAll("A", "B", "C") // A,B,C

fun printAll(vararg texts: Any) {
  val allTexts = texts.joinToString(",")
  println("$allTexts")
}
printAll("A", 1, 'c') // A,1,c

// 값의 배열을 전달할 수 있다. 스프레드 연산자 * 를 이용하면된다.
val texts = arrayOf("B", "C", "D")
printAll(*texts) // B,C,D
printAll("A", *texts, "E") // A,B,C,D,E
