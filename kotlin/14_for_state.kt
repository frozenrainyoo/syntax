
// 자바
{
  String str = "Foo Bar";
  for (int i = 0; i < str.length(); i++)
    System.out.println(str.charAt(i));
}

// 코틀린
// break, continue 지원
{
  var array = arrayOf(1, 2, 3)
  for (item in array)
    print(item)
}


// while 반복문 (조건이 True인 동안 반복)
{
  while(조건) {
    // 코드
  }
}

// do ... while 반복문 (조건이 True인 동안 반복)
{
  do {
    // 코드
  } while (조건)
}

// continue 및 break문과 라벨을 함께 사용하는 방법
// 출력 Outer loop: 1
//     Inter loop: A
{
  val charRange = 'A'..'B'
  val intRange = 1..6

  outer@ for (value in intRange) {
    println("Outer look: $value")

    for (char in charRange) {
      if(char == 'B')
        break@outer
      
      println("\tInter loop: $char")
    }
  }
}
