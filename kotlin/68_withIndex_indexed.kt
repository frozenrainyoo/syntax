// 값과 인덱스의 리스트를 반환하는 withIndex함수를 이용
listOf(9, 8, 7, 6).withIndex()
  .filter { (i, _) -> i % 2 == 0 } // 
  .forEach { (i, v) -> print("$v at $i,") } // 9 at 0, 7 at 2,

val list1 = listOf(2, 2, 3, 3)
  .filterIndexed { index, _ -> index % 2 == 0 }
print(list1) // 2, 3

val list2 = list(10, 10, 10)
  .mapIndexed { index, i -> index * i }
print(list2) // 0, 10, 20

val list3 = listOf(1, 4, 9)
  .forEachIndexed { index, i -> print("$index: $i,") }
print(list3) // 0: 1, 1: 4, 2: 9
