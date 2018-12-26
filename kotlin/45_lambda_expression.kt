// { 인수 -> 함수 본체 }
// { 1 } : 인수
// { s: String -> println(s) } : String인수 하나를 받고 이를 출력하는 람다식 Unit을 반환하며 형식은 (String)->Unit이다.
// { a: Int, b: Int -> a + b } : Int 인수 2개를 받고 그 합을 반환하는 람다식 형식은 (Int, Int)->Int 이다.
// 명시적으로 매개변수를 정의, 람다식의 매개변수를 정의한다.
var a: (Int) -> Int = { i: Int -> return i * 2 }

var i = 1
var a: () -> Int = { ++i }
print(i) // 1
print(a()) // 2
print(i) // 2
print(a()) // 3
print(i) // 3

// 매개변수를 정의하여 인수가 유추되어 간단하게 작성할 수 있다.
val a: (Int) -> Int = { i -> i * 2 }
val c: (String) -> Unit = { s -> println(s) }

// 람다식의 매개변수 형식을 정의하고 속성 형식을 유추하게 하여 간단하게 작성하는 방법
val b = { 4 }
val c = { s: String -> println(s) }
val a = { i: Int -> i * 2 }

// it : 단일 매개변수의 암시적 이름
// it 키워드를 이용하여 매개변수에 접근할 수 있다.
// 매개변수가 하나만 있고, 매개변수 형식을 컨텍스트로부터 유추할 수 있어야 한다.
val a: (Int) -> Int = { it * 2 }
val c: (String) -> Unit = { println(it) }

// LINQ 스타일로 정의된 작업의 가독성을 높여준다.
// strings가 List<String>으로 가정
strings.filter { it.length = 5 }.map { it.toUpperCase() }

// LINQ 스타일은 컬렉션과 문자열 처리의 구문을 아주 단순하고 간결하게 만들 수 있으므로 함수형 언어에서 인기가 많다.

//////////////////////////////////////////////////////////////////////
// 명명된 인수와 람다식의 조합 
fun getAndFillList(
  onStart: () -> Unit = {},
  onFinish: () -> Unit = {}) {
    // 코드
}
// 사용법
getAndFillList(
  onStart = { view.loadingProgress = true },
  onFinish = { view.loadingProgress = false }
)
getAndFillList(onFinish = { view.swipeRefresh.isRefreshing = false })
getAndFillList()

//////////////////////////////////////////////////////////////////////
//마지막 람다식 인수 규칙
fun longOperationAsync(a: Int, callback: () -> Unit) {
  // ...
}
// 사용법
longOperationAsync(10) {
  hideProgress()
}

//////////////////////////////////////////////////////////////////////
//주변 코드 명명
fun addLogs(tag: String, f: () -> Unit) {
  println("$tag started")
  val startTime = System.currentTimeMillis()
  f()
  val endTime = System.currentTimeMillis()
  println("$tag finished. It took" + (endTime - startTime))
}
//사용법
addLogs("Some operations") {
  // 측정하려는 작업
  Thread.sleep(1000)
}
// Some operations started
// Some operations finished. It took 1001

///////////////////////////////////////////////
// 사용되지 않는 변수를 위한 밑줄
list.filterIndexed { index, value -> index % 2 == 0 }
// value는 사용되지 않는 매개변수로 코드를 이해하기 힘들다. 그래서 매개변수의 이름을 대체하는 밑줄 표기법을 지원한다.
list.filterIndexed { index, _ -> index % 2 == 0 }


///////////////////////////////////////////////
// 람다식의 구조분해
data class User(val name: String, val surname: String, val phone:String)
val (name, surname, phone) = user

val showUser: (User) -> Unit = { (name, surname, phone) ->
  println("$name $surname have phone number: $phone")
}
val user = User("Marcin", "oskala", "+39 3939 3939")
showUser(user)
