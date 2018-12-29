// 형식 삭제는 제네릭이 도입되지 이전 버전과의 하위 호환성을 보장하기 위해 JVM에 추가됐다.
// 형식 삭제는 제네릭 형식에서 형식 인수를 제거하는 처리이며, 결과적으로 런타임에 제네릭 형식의 형식 정보가
// 부분적으로 손실된다.

package test
class Box<T>

val intBox = Box<Int>()
val stringBox = Box<String>()

println(intBox.javaClass) // test.Box
println(stringBox.javaClass) // test.Box
// 컴파일러는 두 형식을 구분하고 형식 안전성을 보장할 수 있다. 그런데 컴파일러는 컴파일 중에 매개변수화된 형식
// Box<Int>와 Box<String>이 모두 Box로 변환된다. 생성된 자바 바이트코드에는 형식 인수와 관련된 정보가 없기
// 때문에 런타임에는 제네릭 형식을 구분할 수 없다.

//////////////////
// 생성된 함수의 JVM 이름을 변경해 이 문제를 해결할 수 있다.
@JvmName("intSum") fun sum(ints: List<Int>) {
  println("Ints")
}
fun sum(strings: List<String>) {
  println("Ints")
}
