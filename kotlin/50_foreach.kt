// 논로컬반환
fun forEach(list: List<Int>, body: (Int) -> Unit) {
  for (i in list) body(i)
}

// 사용법
val list = listOf(1, 2, 3, 4, 5)
forEach(list) {
  print(it) // 12345
}

// 바깥 함수로부터 반환할 수 없는 단점이 있다.
// 아래 for문은 가능하다.
// 불가능한 이유는 컴파일되는 방법과 관계가 있다. 람다식은 정의된 코드를 한 메소드 안에 포함하는 익명 객체의
// 클래스로 컴파일된다. 이 메소드에서는 컨텍스트가 다르기 때문에 maxBounded를 반환할 수 없다.
fun maxBounded(list: List<Int>, upperBound: Int, lowerBound: Int): Int {
  var currentMax = lowerBound
  for( i in list) {
    when {
      i > upperBound -> return upperBound // [return_not_allowed]
      i > currentMax -> currentMax = i
    }
  }
  return currentMax
}

// forEach를 inline으로 지정할 경우 컴파일 중에 
// 이 함수의 코드가 함수 호출을 대체되어 return을 사용해도 문제가 없다.
inline fun forEach(list: List<Int>, body: (Int) -> Unit) {
  for (i in list) body(i)
}

fun maxBounded(list: List<Int>, upperBound: Int, lowerBound: Int): Int {
  var currentMax = lowerBound
  forEach(list) { i ->
    when {
      i > upperBound -> return upperBound
      i > currentMax -> currentMax = i
    }
  }
  return currentMax
}
