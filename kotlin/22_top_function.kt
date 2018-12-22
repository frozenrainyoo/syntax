//Test.kt
package com.example

fun printTwo() {
  print(2)
}

// Main.kt
import com.example.printTwo

fun main(args: array<String>) {
  printTwo()
}

// 최상위 함수는 유용한 경우가 많지만, 주의해서 사용해야 한다. 
// public 최상위 함수를 정의하면 코드 힌트 리스트에 나오는 함수의 수가 증가한다는 데 주의하자.
// 최상의 함수로서 적절한 몇 가지 예
// factorial
// maxOf, minOf
// listOf
// println

// 적절하지 않은 예
// sendUserData

// 자바로 바이트코드
public final class PrintKt {
  public static void printTwo() {
    System.out.print(2);
  }
}
PrintKt.printTwo();

// Max.kt
@file:JvmName("Math")
@file:JvmMultifileClass
package com.example.math
fun max(n1: Int, n2: Int): Int = if(n1 > n2) n1 else n2

// Min.kt
@file:JvmName("Math")
@file:JvmMultifileClass
package com.example.math
fun min(n1: Int, n2: Int): Int = if(n1 < n2) n1 else n2

// 자바에서 다음과 같이 사용 가능하다.
Math.min(1, 2)
Math.max(1, 2)
