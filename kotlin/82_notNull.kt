// notNull 함수 
// null 불허 변수를 객체 생성 시점에 초기화되지 않고 나중에 초기화되도록 정의할 수 있게 해준다.
// 기본값을 제공하지 않고 변수를 null 불허로 정의할 수 있다.
// notnull 함수는 lateinit 대신 사용할 수 있다.
import kotlin.properties.Delegates.notNull
var someProperty: SomeType by notNull()
//
lateinit var someProperty: SomeType

//lateinit는 notNull 대리자보다 빠르므로 가능하다면 lateInit를 사용하는 것이 좋지만,
// lateinit는 기본형이나 최상위 속성에는 사용할 수 없으므로, 이 경우 notNull을 사용해야 한다.
// notNull 함수 구현은 다음과 같다.
public fun <T: Any> notNull(): ReadWriteProperty<Any?, T> =
  NotNullVar()

//사용법
var name: String by Delegates.notNull()
println(name) // 오류 name 속성을 사용하기 전에 초기화해야 한다. 

