// nested class
class Outer {
  private val bar: Int = 1

  // 바깥 클래스이 멤버에 접근할 수 있게 하려면 중첩 클래스에 inner 한정자를 지정해 다른 종류의 클래스를 만들어야 한다.
  inner class Inner {
    fun foo() = bar
  }
}

val outer = Outer()
val demo = outer.Inner().foo() // == 1

class Outer {
  private val bar: Int = 1

  class Nested {
    fun foo() = 2
  }
}

val demo = Outer.Nested().foo() // == 2
