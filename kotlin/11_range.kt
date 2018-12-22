// 범위는 내부적으로 ragneTo 연산자를 이용한다.
val intRange = 1..4 // 1
val charRange = 'b'..'g' // 2

for (i in 1..5) print(i) // 12345
for (i in 'b'..'g') print(i) // bcdefg

// 출력 : 52 is in 50..75 range
{
  val weight = 52
  val healthy = 50..75

  if (weight in healthy)
    println("$weight is in $healthy range")
}

// k is a character
{
  val c = 'k' // 유추된 형식은 Char
  val alphabet = 'a'..'z'

  if (c in alphabet)
    println("$c is character")
}

for (i in 1..3) print(i) // 123
for (i in 5..1) print(i) // 아무것도 출력되지 않는다.
for (i in 5 downTo 1) print(i) // 54321
for (i in 3..6 step 2) print(i) // 35
for (i in 9 downTo 1 step 3) print(i) // 963
