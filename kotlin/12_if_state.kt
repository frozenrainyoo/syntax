// 기본 형식
val x = 5
if (x > 10) {
  println("greater")
} else {
  println("smaller")
}


// 간결한 구문 가능
println(if(x > 10) "greater" else "smaller")

// 변수에 곧바로 할당하는 방법
val greeting = if (hour < 18) "Good day" else "Good evening"

// 문자열 탬플릿 안에서 아용하는 방법
val age = 18
val message = "You are ${ if (age < 18) "young" else "of age" } person"
// you are of age person
