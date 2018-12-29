// 모든 객체에 대해 중위 확장 함수를 만들 수 있는데, 이러한 확장 함수의 유형 중 하나로 2장
// 기본 개념에서 간단히 소개한 to가 있다.
infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)

println( 1 to 2 == Pair(1, 2) ) // true

////
infix fun <T> List<T>. intersection(other: List<T>)
  = filter { it in other }

listOf(1, 2, 3) intersection listOf(2, 3, 4) // [2, 3]
