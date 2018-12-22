
const val MAX_LOG_ENTRIES = 100
  @MyLogger(MAX_LOG_ENTRIES)
  // 컴파일 타입에 얻을 수 있는 값
  class Test {}

// const를 사용할 때는 제약이 있다.
// 첫 번째는 기본형이나 String 형식으로 값을 초기화해야 한다.
// 두 번째는 객체의 멤버나 최상위 수준으로 선언해야 한다는 것이다.
// 세 번째는 맞춤형 게터를 가질 수 없다는 점이다.
