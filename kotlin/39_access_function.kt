// 접근자
// public (default)
// private - 선언이 포함된 파일 안에서 요소를 볼 수 있다.
// protected - 최상위에서 사용할 수 없다. 선언과 하위 클래스를 포함하는 클래스 안에서 볼 수 있다.
// internal - 동일한 모듈 내의 모든 곳에서 요소를 볼 수 있다.

class Person {
  public val name: String = "Igor"
  protected var age: Int = 22
  internal fun learn() {}
  private fun speak() {}
}

val person = Person()
print(person.name) // Ok
person.speak() // Error
person.age // Error
person.learn() // Ok

class Student() : Person() {
  fun doSth() {
    print(name) // Ok
    learn() // Ok
    print(age) // Ok
    speak() // Error
  }
}

// internal의 경우 java에 없는 접근자로 자바에서 사용하기 위해서는 아래와 같이 사용해야 한다.
public class Java {
  void a() {
    new Person().learn$production_sources_for_module_SmallTest();
  }
}

// 생성자에 접근자 설정방법
internal class Fruit private constructor {
  var weight: Double? = null

  companion object {
    fun create() = Fruit()
  }
}

var fruit: Fruit? = null // Ok
fruit = Fruit() // Error
fruit = Fruit.create() // Ok

// getter, setter에 접근자 지정방법
class Car {
  init {
    count++;
    println("Car created")
  }

  companion object {
    init {
      println("Car companion object created")
    }
    var count: Int = 0
      private set
  }
}
