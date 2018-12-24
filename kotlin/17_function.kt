// 메인 함수
fun main(args: Array<String>) {
  println("Hello World")
}

fun double(i: Int): Int { // i는 매개변수
  return 2 * i
}

val a = double(5) // 5는 아규먼트

// 매개변수
// 코틀린 함수의 매개변수는 파스칼 표기법을 이용해 선언
// 각 매개변수의 형식을 명시적으로 지정해야 한다.
// 모든 변수는 읽기 전용 변수로 정의되며, 매개변수를 가변으로 만들 수는 없다.
fun funcDuplicates(list: List<Int>): Set<Int> {
  var list = list.sorted()
}

// 인수(argument) 함수를 호출하면서 함수로 전달하는 값을 의미
// 매개변수(parameter) 함수 선언 안에 있는 변수를 의미
// 프로시저procedure(값을 반환하지 않는 함수)
fun presentGently(v: Any?, a: Int) {
  println("Hello $v")
}

// 함수에서 반환
// 코틀린에서 프로시저가 없고 모든 함수가 일종의 값을 반환한다.
// 반환값을 지정하지 않을 경우 기본 반환 값은 Unit 인스턴스다.
// Unit = Java의 void
fun main(args: Array<String>) {
    val p = printSum(1, 2) 
    println(p is Unit)
}
fun printSum(a: Int, b: Int): Unit{ 
	val sum = a + b
}
// Unit은 싱글톤이므로 하나의 인스턴스만 존재한다.

// 반환형식이 Unit인 함수에서 출력을 반환하려면 아무 값을 지정하지 않고 return문을 사용하면 된다.
fun printSum(a: Int, b: Int) {
  if (a < 0 || b < 0) {
    return
  }
  val sum = a + b
  print(sum)
}

// (매개변수 형식)->반환 형식
// (Int)->Int : Int 인수로 받고 Int를 반환하는 함수
// ()->Int : 인수를 받지 않고 Int를 반환하는 함수
// (Int)->Unit: Int 인수로 받고 아무것도 반환하지 않는 함수(실제로 반환할 필요가 없는 Unit)
