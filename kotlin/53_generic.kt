// 제네릭은 클래스, 함수, 데이터 구조, 알고리즘의 정확한 형식을 나중에 지정할 수 있도록 작성하는
// 프로그래밍 스타일을 의미한다.

class SimpleList<T> {
  fun add(item:T) {

  }
  fun get(index: Int): T {

  }
}

class Student(val name: String)
val studentList = SimpleList<Student>()
studentList.add(Student("Ted"))
println(studentList.getItemAt(0).name)

// 코틀린 표준 라이브러리는 kotlin.colletions 패키지에 List, Set, Map등의 여러 제네릭 컬렉션을 정의한다.

val fruits = listOf("Banana", "Orange", "Apple", "Blueberry")
val bFruits = fruits.filter { it.startsWith("B") }
println(bFruits)

// 제약 조건
// 기본적으로 매개변수의 암시적 상한은 Any?로 설정되어 있다.

class SimpleList<T>
class Student

var intList = SimpleList<Int>()
var studentList = SimpleList<Student>()
var carList = SimpleList<Boolean>()

/////////////////////////////////////////////
// Number 클래스는 추ㅏㅇ 클래스이며 코틀린 숫자 형식(Byte, Short, Int, Long, Float, Double)의
// 상위 클래스이다. 하위 클래스인 Int, Double 형식인수로 사용할 수 있지만 Number의 하위 클래스가 아닌
// String 클래스는 사용할 수 없다.

class SimpleList<T: Number>

var numberList = SimpleList<Number>()
var intList = SimpleList<Int>()
var doubleList = SimpleList<Double>()
var stringList = SimpleList<String>() // Error

/////////////////////////////////////////////
// null 가능성

class Action (val name:String)
class ActionGroup<T : Action>

var actionGroupA: ActionGroup<Action>
var actionGroupB: ActionGroup<Action?> // Error
