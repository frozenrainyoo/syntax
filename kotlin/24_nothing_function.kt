// 정상적으로 종료되지 않는 함수를 정의할 경우 사용.
// throwError 리턴하는 경우
// 오류 처리를 테스트해야 할 경우

fun fail(): Nothing = throw Error()

fun processElement(element: Element) {
  fun throwError(message: String): Nothing
  = throw ProcessingError("error in $element $message")

  if (element.kind != ElementKind.METHOD)
    throwError("Not a method")
}

// 함수 반환 형식에 영향을 주지 않고 throw문과 같이 사용할 수 있다.
fun getFirstCharOrFail(str: String): Char
  = if(str.isNotEmpty()) str[0] else fail()

val name: String = getName() ?: fail()

val enclosingElement = element.enclosingElement ?: throwError("error")
// Nothing을 Empty type이라고 하는 이유다.
// 어떤 값도 런타임에 이 형식을 가질 수 없지만, 동시에 다른 모든 클래스의 하위 형식일 수 있다.
