// DSL (domain-specific language)

fun TextView.addOnTextChangedListener(config: TextWatcherConfig.()->Unit) {
  val textWatcher = TextWatcherConfig()
  textWatcher.config()
  addTextChangedListener(textWatcher)
}

searchView.addOnTextchangedListener {
  onTextChanged { text, start, before, count ->
    presenter.onSearchChanged(text)
  }
}

// _를 사용해 불 필요한 매개변수를 숨겨서 구현
searchView.addOnTextChangedListener {
  onTextChanged { text, _, _, _ ->
    presenter.onSearchChanged(text)
  }
}

// 두 가지 콜백을 모두 구현할 수 있다.
searchView.addOnTextChangedListener {
  beforeTextChanged { _, _, _, _ ->
    Log.i(TAG, "beforeTextChanged invoked")
  }
  onTextChanged { text, _, _, _ ->
    presenter.onSearchChanged(text)
  }
  afterTextChanged {
    Log.i(TAG, "afterTextChanged invoked")
  }
}

// 특징
// 객체 식 구현보다 짧다.
// 기본 함수 구현을 포함한다.
// 불필요한 매개변수를 숨길 수 있다.

// DSL은 아주 강력한 개념이며 코틀린 커뮤니티에서 빠른 속도로 확산되고 있다.

// Anko 안드로이드 레이아웃 파일 https://github.com/Kotlin/anko/wiki/Anko-Layouts
// 그레이들 구성 파일
// HTML 파일 kotlinx.html
// Kotson JSON 파일
