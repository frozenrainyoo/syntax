// 확장 함수
// 개발자가 정의한 맞춤형 클래스나 타사 라이브러리 또는 안드로이드 프레임워크에 정의된 View, List, String 및
// 기타 클래스에 대해 비슷한 확장 함수를 정의할 수 있다.
fun Context.toast(text: String) {
  Toast.makeText(this, text, LENGTH_LONG).show()
}
context.toast("Some toast")

fun Collection<Int>.dropPercent(percent: Double) = this.drop(floor(this.size * percent))
fun Collection<Int>.dropPercent(percent: Double) = drop(floor(size * percent))

fun Any?.logError(error: Throwable, message: String = "error") {
  Log.e(this?.javaClass?.simpleName ?: "null", message, error)
}
user.logError(e, "NameError") // Logs: User: NameErrror ...
"String".logError(e) // String: error ...
logError(e) // 1, MainActivity: error ...

////////////////////////////////////////////////////////
// 메소드 재정의 불가
class A {
  fun foo() {
    print("foo from A")
  }
}

fun A.foo() {
  print("foo from Extension")
}

A().foo() // foo from A

// 상위 클래스의 메소드도 확장 함수를 이긴다.
open class A {
  fun foo() {
    print("foo from A")
  }
}

class B: A()
fun B.foo() {
  print("foo from Extension")
}
A().foo() // foo from A

// 수신자 요소 접근
// private와 protected 요소에는 접근할 수 없고, 자바 default, 자바 pcakage 또는 자바 internal
// 요소는 표준 객체에서 작업할 때와 마찬가지로 접근할 수 있다.

// 확장은 정적으로 확인된다.
abstract class A
class B: A()

fun A.foo() {
  print("foo(A)")
}
fun B.foo() {
  print("foo(B)")
}

val b = B()
b.foo() // foo(B)
(b as A).foo() // foo(A)
val a: A = b
a.foo() // foo(A)
