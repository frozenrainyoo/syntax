inline val now: Long
get() {
  return System.currentTimeMillis()
}
// 속성 호출은 컴파일 중에 최적화되며, 실제로 속성을 호출하는 대신 호출이 속성 본체로 대체된다.
// 인라인을 사용하면 추가 객체를 생성할 필요가 없으며, 게터를 호출하지 않고 호출을 본체로 대체하므로 성능이 개선된다.
// 인라인은 기반 필드가 없는 속성에만 적용할 수 있다는 한 가지 제한이 있다.


///////////////////////////////////////////////
inline fun printExecutionTime(f: () -> Unit) {
  val startTime = System.currentTimeMillis()
  f()
  val endTime = System.currentTimeMillis()
  println("It took " + (endTime - startTime))
}

fun measureOperation() {
  printExecutionTime {
    longOperation()
  }
}

// 컴파일하게 되면 아래 코드로 대체된다.
fun measureOperation() {
  val startTime = System.currentTimeMillis()
  longOperation()
  val endTime = System.currentTimeMillis()
  println("It took " + (endTime - startTime))
}

// 인라인 함수를 이용하면 람다식을 위한 클래스를 만들 필요 없이 함수 매개변수가 있는 함수의 실행 속도를 개선할 수 있다.
// 개선 효과가 상당히 크기 때문에 함수 매개변수가 하나라도 있는 모든 작은 함수에 inline 한정자를 사용하는 것이 권장된다.

///////////////////////////////////////////////
// inline 부작용
// 바이트코드가 길어진다.
// 인라인 함수를 재귀할 수 없다.
// public inline 함수는 private 함수를 사용할 수 없다. 
internal fun someFun() {}
inline fun inlineFun() {
  someFun() // Error
}
// 함수가 인라인일 때는 해당 함수 인수를 인라인이 아닌 다른 함수로 전달할 수 없다.
fun boo(f: () -> Int) {
  // ...
}
inline fun foo(f: () -> Int) {
  boo(f) // Error
}
// boo함수도 inline일 경우 가능하다.

///////////////////////////////////////////////
// noinline 한정자를 이용하여 인라인이 아닌 함수로 인자를 전달할 수 있다.
// noinline을 사용하는 중요한 이유
// * 특정한 람다를 다른 함수로 전달해야 할 때
// * 람다를 많이 호출하지만 코드가 지나치게 비대해지는 것을 원하지 않을 때
fun boo(f: () -> Unit) {
  //...
}

inline fun foo(before: () -> Unit, noinline f: () -> Unit) {
  before()
  boo (f)
}

///////////////////////////////////////////////
// crossinline 한정자
// 논로컬 반환을 금지하도록 컴파일러에게 알리려면 이 parameter에 crossinline을 지정해야 한다.
// 그러면 다른 람다식 안에서 사용해도 인라인 함수에서 필요로 하는 대체처럼 작동한다.
// crossinline parameter는 다른 함수에 argument로 전달할 수 없다.
fun boo(f: () -> Unit) {
  ...
}

inline fun foo(crossinline f: () -> Unit) {
  boo { println("A"); f() }
}

fun main(args: Array<String>) {
  foo { println("B") }
}
// 컴파일되면 아래와 같다.
fun main(args: Array<String>) {
  boo { println("A"); println("B")}
}

///////////////////////////////////////////////
// 인라인 속성
var viewIsVisible: Boolean
inline get() = findViewById(R.id.view).visibility = View.VISIBLE
inline set(value) {
  findViewById(R.id.view).visibility = if (value) View.VISIBLE
  else View.GONE
}

// 전체 속성을 인라인으로 만들어도 동일하다.
inline var viewIsVisible: Boolean
get() = findViewById(R.id.view).visibility = View.VISIBLE
  set(value) {
    findViewById(R.id.view).visibility = if (value) View.VISIBLE
      else View.GONE
  }

// 사용법
if (!viewIsVisible)
  viewIsVisible = true
