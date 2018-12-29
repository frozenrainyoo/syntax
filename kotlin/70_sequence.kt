val = generateSequence(1) { it + 1 }
  .map { it * 2 }
  .take(10)
  .toList()
println(numbers) // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
// generateSequence함수는 시퀀스를 생성하는 방법 중 하나다. 이 시퀀스는 1부터 무한대까지 숫자를 포함한다.

val seq = generateSequence(1) { println("Generated $(it+1)"); it + 1 }
  .filter { println("Processing of filter: $it"); it % 2 == 1 }
  .map { println("Processing map: $it"); it * 2 }
  .take(2)

seq.toList()
// Processing of filter: 1
// Processing map: 1
// Generated 2
// Processing of filter: 2
// Generated: 3
// Processing of filter: 3
// Processing map: 3
