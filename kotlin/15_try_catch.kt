
// 함수 선언 : 함수에서 어떤 예외가 생성될 수 있는지 선언해야 한다. (검사되는 예외)
//           함수 선언에 생성될 수 있는 예외에 대한 정보가 포함되지 않는다. (검사되지 않는 예외)
// 예외 처리 : 예외를 생성하는 코드를 try ... catch 블록으로 감싸야 한다. (검사되는 예외)
//           원한다면 예외를 포착하고 처리할 수 있지만 필수는 아니다. 예외는 호출 스택에서 상위로 올라간다.(검사되지 않는 예외)

// 코틀린과 자바 예외 시스템의 가장 큰 차이는 코틀린에서는 모든 예외가 검사되지 않는 예외라는 점이다.
// 검사되는 예외를 생성할 수 있는 자바 메소드를 호출하는 코드도 try ... catch 블록으로 감쌀 필요가 없다. 물론 해도 되지만 의무는 아니다.
fun foo() {
  throw IOException()
}

fun bar() {
  foo() // try..catch 블록으로 감쌀 필요가 없다.
}


fun sendFormDate(user: User?, data: Data?) {
  user ?: throw NullPointerException("User cannot be null")
  data ?: throw NullPointerException("Date cannot be null")
}

fun onSendDataClicked() {
  try {
    sendFormDate(user, data)
  } catch (e: AssertionError) {
    // 오류 처리
  } finally {
    // 선택적인 finally 블록
  }
}

// 안드로이드에서 특정 안드로이드 애플리케이션이 설치되었는지 확인
// try블록 마지막 작업으로 해당하는 true가 변수에 할당된다.
val result = try {
  context.packageManager.getPackageInfo("com.text.app", 0)
  true
} catch (ex: packageManager.NameNotFoundException) {
  false
}
