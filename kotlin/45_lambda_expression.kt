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
