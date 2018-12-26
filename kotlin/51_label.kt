// 람다식의 라벨반환

// forEach 제네릭 구현, 모든 형식의 리스트를 처리할 수 있다.
inline fun <T> forEach(list: List<T>, body: (T) -> Unit) {
  for (i in list) body(i)
}

fun printMessageButNotError(messages: List<String>) {
  // forEach 인수 안에 람다식에 대한 라벨을 정의한다.
  forEach(messages) messageProcessor@ {
    if (it == "ERROR")
      return@messageProcessor // 라벨로 지정한 람다식에서 반환한다.

    return(it)
  }
}

// 사용법
val list = listOf("A", "ERROR", "B", "ERROR", "C")
printMessageButNotError(list) // ABC

////////////////////////////////////////////////////////////
// 암시적 라벨 (implicit label)
// 코틀린에서 함수 인수로서 정의된 람다식은 함수의 이름과 같은 기본 라벨을 갖는다.
// 예를 들어 forEach함수에서 정의된 람다식에서 반환하려면 return@forEach를 사용할 수 있다.
inline fun <T> forEach(list: List<T>, body: (T) -> Unit) {
  for (i in list) body(i)
}

fun printMessageButNotError(messages: List<String>) {
  // forEach 인수 안에 람다식에 대한 라벨을 정의한다.
  forEach(messages) {
    if (it == "ERROR")
      return@forEach // 라벨로 지정한 람다식에서 반환한다.

    return(it)
  }
}
