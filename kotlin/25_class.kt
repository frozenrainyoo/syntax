class Person(
  var name: String, // 읽기 쓰기 속성( getter, setter 생성됨)
  val age: Int, // 읽기 전용 속성 (getter만 생성됨)
  var speed: Double
)
val person = Person("Eva", 22, 7.0)

val name = person.name
person.name = "Justin"

val age = person.age
person.age = 25 // Error

person.speed++ // 8.0
person.speed-- 
--person.speed // 6.0

// class 정의 방법
class Person (
  var name: String,
  var age: Int
)

class Person {
  // getter, setter는 코틀린 컴파일러가 생성한다.
  var name: String
  var age: Int

  // 자바 생성자와 동등하다. secondary constructor다.
  constructor(name: String, age: Int) {
    this.name = name
    this.age = age
  }
}

// primary constructor 이용하여 class 정의하기
class Person constructor(name: String, age: Int) {
  var name: String
  var age: Int

  // primary constructor
  init {
    this.name = name
    this.age = age
  }
}

// 생성자 매개변수에 접근하여 코드 간소화 하기
class Person constructor(name: String, age:Int) {
  var name: String = name
  var age: Int = age
}
