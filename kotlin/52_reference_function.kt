// 함수 참조 ::functionName
// argument로 전달하려는 함수가 이미 별도의 함수로 정의된 경우가 있다. 이 때는 간단하게 함수 호출로 람다를 정의할 수 있다.
// 코틀린에서는 함수를 값으로도 전달할 수 있다. 최상위 함수를 값으로서 이용하려면 콜론 2개와 함수 이름으로 지정한다.

fun isOdd(i: Int) = i % 2 == 1
list.filter { isOdd(it) } // 람다 
list.filter(::isOdd) // 함수 참조 이용

//////////////////////////////////////////////
// 예 1
fun greet() {
  print("Hello! ")
}
fun salute() {
  print("Hava a nice day ")
}

val todoList: List<() -> Unit> = listOf(::greet, ::salute)

for (task in todoList) {
  task()
}
// Hello! Have a nice day

// 함수 참조는 리플렉션의 예이다.

//////////////////////////////////////////////
// 예 2
val isStringEmpty: (String)->Boolean = String::isEmpty
// 사용법
val nonEmpty = listOf("A", "", "B", "").filter(String::isNotEmpty)
print(nonEmpty) // ["A", "B"]

//////////////////////////////////////////////
// 자바 정적 메소드를 참조할 때는 메소드가 정의된 클래스의 인스턴스가 필요 없으므로 상황에 차이가 있다.
// 객체를 사전에 알고 있으므로 제공할 필요가 없는 컴패니언 객체나 객체의 메소드와 비슷하다.

object MathHelpers {
  fun isEven(i: Int) = i % 2 == 0
}
class Math {
  companion object {
    fun isOdd(i: Int) = i % 2 == 1
  }
}

// 사용법
val evenPredicate: (Int)->Boolean = MathHelpers::isEven
val oddPredicate: (Int)->Boolean = Math.Companion::isOdd
val numbers = 1..10
val even = numbers.filter(evenPredicate)
val odd = numbers.filter(oddPredicate)
println(even) // 2, 4, 6, 8, 10
println(odd) // 1, 3, 5, 7, 9

//////////////////////////////////////////////
// 바인딩 참조 bound reference
getUsers().smartSubscribe (
  onStart = view::showProgress,
  onNext = this::onUsersLoaded,
  onError = view::displayError,
  onFinish = view::hideProgress
)

// 참조할 필요가 잇는 다른 함수에는 생성자가 있으며, 이러한 사례의 예로 DTO(Data Transfer Object)와 모
// 델의 일부인 클래스를 매핑하는 작업을 들 수 있다.
fun toUsers(usersDto: List<UserDto>) = usersDto.map { User(it) }

// * DTO는 프로세스 간에 데이터를 전달하는 객체이며, 이러한 객체가 필요한 이유는 시스템간의 통신에 사용되는 API클래스
// 가 시스템에서 사용되는 실제 클래스(모델)와 다르기 때문이다.
// ::ClassName 으로 생성자를 참조할 수 있다.
val mapper: (UserDto)->User = ::User
fun toUsers(usersDto: List<UserDto>) = usersDto.map(::User)
