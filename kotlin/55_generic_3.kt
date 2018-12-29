// public, protected, internal 
// 고정 in / out
// 공변(out) out
// 반변(in) in
// private
// 고정 in / out
// 공변(out) in / out
// 반변(in) in/ out

class ConsumerProducer<in T, out R> {
  private fun consumeItemT(t: T): Unit { }
  private fun consumeItemR(r: R): Unit { }
  private fun produceItemT(): T {
    // T 형식의 인스턴스 반환
  }
  private fun produceItemR(): R {
    // R 형식의 인스턴스 반환
  }
}

// 고정 생성자
class Producer<out T>(t: T)
// 사용법
val stringProducer = Producer("A")
val anyProducer: Producer<Any> = stringProducer

class Producer<out T>(val t: T) // ok 안전
class Producer<out T>(var t: T) // Error 불안전
class Producer<out T>(private var t: T) // 변량 제한은 외부 클라이언트에만 적용된다고 했으므로
// private 가시성 한정자를 추가하면 공변 읽기 쓰기 속성을 정의할 수 있다.


// 형식 매개변수 명명 규칙
// 공식 자바 형식 매개변수 명명 규칙
// https://docs.oracle.com/javase/tutorial/java/generics/types.html
// E : 요소
// K : 키
// N : 숫자
// T : 형식 타입 T, T2 T3
// V : 값
// S, U, V, ... : 2번째, 3번째 ,4번째 형ㅅ식
