// 익명 함수

// 명시적으로 익명 함수를 적용하는 방법
val a: (Int) -> Int = fun(i: Int) = i * 2
val b: () -> Int = fun(): Int { return 4 }
val c: (String) -> Unit = fun(s: String) { println(s) }

// 코틀린의 형식 유추로 아래처럼 간단하게 정의할 수 있다.
val a = fun(i: Int) = i * 2
val b = fun(): Int { return 4 }
val c = fun(s: String) { println(s) }

println(a(10)) // 20
println(b()) // 4
c("Kotlin rules") // Kotlin rules

// 안전 호출을 이용해 invoke 메소드를 이용하는 사용 패턴
var a: ((Int) -> Int)? = null
if (false)
    a = fun(i: Int) = i * 2

print(a?.invoke(4)) // null

