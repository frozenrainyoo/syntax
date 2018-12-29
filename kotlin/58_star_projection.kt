// 별표 프로젝션
// 형식 삭제 때문에 런타임에는 불완전한 형식 정보만 제공된다. 예를 들어, 제네릭 형식의 형식 매개변수는 알 수 없다. 
val list = listOf(1, 2, 3)
println(list.javaClass) // class java.util.Array$ArrayList

// 코틀린은 자바와 달리 원시 형식의 선언을 허용하지 않는다.
SimpleList<> // 자바 가능 , 코틀린 오류
// 대신 코틀린은 누락되거나 중요하지 않은 형식 인수에 대해 정보를 알려 줄 수 있는 * 를 지원한다.

if (collection is List<*>) {

}

class Box<T>
val anyBox = Box<Any>()
val intBox = Box<Int>()
val stringBox = Box<String>()
var unknownBox: Box<*>
unknownBox = anyBox // OK
unknownBox = intBox // OK
unknownBox = stringBox // OK
