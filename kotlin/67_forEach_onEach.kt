
listOf("A", "B", "C").forEach { print(it) } // ABC

// onEach는 forEach와 비슷하며 스트림을 처리하면서 각 요소에 작업을 호출할 수 있도록 확장 수신자를 반환한다.
// onEach의 일반적인 용도는 로깅이다.
(1..10).filter { it % 3 == 0 }
  .onEach(::print) // 369
  .map { it / 3 }
  .forEach{::print} // 123
