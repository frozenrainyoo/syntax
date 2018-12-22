// 기본 인수 값 default argument
fun printValue(value: String, inBracket: Boolean = true,
              prefix: String = "", suffix: String = "") {
  print(prefix)
  if (isBracket) {
    print("(${value})")
  } else {
    print(value)
  }
  println(suffix)
}
printValue("str", true, "", "") // (str)
printValue("str") // (str)
printValue("str", false) // str

// 명명된 인수 구문 named argument syntax
printValue("str", suffix = "!") // (str)!
printValue("str", inBracket = true) // (str)
printValue("str", prefix = "Value is ", suffix = "!!", inBracket = true) // Value is (str)!!

// 일단 명명된 인수 구문을 사용하면 다음 인수에는 기존 구문을 사용할 수 없다.
printValue("str", inBracket = true, "") // Error
