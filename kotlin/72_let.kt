val newNumber = number.plus(2.0)
  .let { pow(it, 2.0) }
  .times(2)

val newNumber = number?.plus(2.0)
  ?.let { pow(it, 2.0) }

// let 함수는 단순하게 null 허용 읽기 쓰기 속성을 언팩하려고 할 때도 선호된다. 이러한
// 속성은 스마트 형변환할 수 없으며, 다음과 같이 섀도잉 속성을 만들어야 한다.

// name 변수는 섀도잉 속성 이름이며, 스마트 형변환은 가변 또는 로컬 변수에만 허용되므로
// 읽기 쓰기 속성의 경우 이 과정이 필요하다.
name?.let { setNewName(it) }
name?.let { setNewName(it) } ?: throw Error("No name setten")

text.replace("{name}", name)
  .let(::correctStyle)
  .capitalize()
  .let(::print)
