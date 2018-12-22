fun getState(state: State, n: Int): State {
  var state = state
  for (i in 1..n) {
    state = state.nextState()
  }
  return state
}

// 꼬리 재귀 함수 tail recursive function
// 컴파일러는 재귀 호출을 최적화하고 StackOverflowError에 대한 걱정 없이 더 효율적인
// 방법으로 재귀 작업을 수행할 수 있다. tailrec 한정자를 지정하면된다.
tailrec fun getState(state: State, n: Int): State =
  if (n <= 0) state
  else getState(state.nextState(), n - 1)

// 아래 재귀 함수를 호출할 때마다 이전 함수의 반환 주소를 스택에 저장하여
// 너무 깊게 재귀할 경우 StackOverflowError가 발생한다.
fun getState(state: State, n: Int): State =
    if (n <= 0) state
    else getState(nextState(state), n - 1)
