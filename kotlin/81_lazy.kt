// lazy 함수

private var _someProperty: SomeType? = null
private val somePropertyLock = Any()
val someProperty: SomeType
get() {
  synchronized(somePropertyLock) {
    if (_someProperty == null) {
      _someProperty = SomeType()
    }
    return _someProperty!!
  }
}
// 객체가 처음 사용될 때 한 번만 객체를 초기화하고 싶은 경우가 있다.
// 코틀린은 이 문제를 간단하게 해결할 수 있는 지연 대리가를 지원한다.
// 읽기 전용속성(val)에만 사용할 수 있다.
val someProperty by lazy { SomeType() }

// 지연 대리자를 지원하는 표준 라이브러리의 lazy함수는 다음과 같다.
public fun <T> lazy(initializer: () -> T) :
  Lazy<T> = SynchronizedLazyImpl(initializer)


// 장점 
// 처음 사용할 때까지 값 초기화가 지연되므로 클래스 초기화가 빨라지고 애플리케이션 시작 시간이 단축된다.
// 실행 흐름에 따라 사용되지 않는 값은 초기화되지 않으므로 자원을 절약할 수 있다.

class MainActivity: Activity() {
  val questionLabelView: TextView by lazy
    { findViewById(R.id.main_question_label) as TextView }

  override fun onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
  }
}
// 속성이 한 위치에서 선언 및 초기화되므로 코드가 더 간결하다.
// 속성이 null 허용이 아니라 null 불허가 되므로 불필요한 null 검사를 방지할 수 있다.
// 속성이 읽기 전용이므로 스레드 동기화나 스마트 형변환같은 모든 혜택을 누릴 수 있다.
// 지연 대리자로 전달한 람다는 속성에 처음 접근할 때만 실행된다.
// 클래스 생성 이후에 값을 얻으므로 시작 속도가 개선된다. 이러한 뷰 일부를 사용하지 않으면 해당 값은 아예 얻지 못 한다.
// 컴파일러가 사용되지 않는 속성을 표시한다. 반면에 자바 구현에서는 컴파일러가 값 설정을 사용으로 간주하므로 사용되지 않는 속성을 파악할 수 없다.

// 확장 함수로 변환하여 구현을 더 개선한다.
fun <T: View> Activity.bindView(viewId: Int) = lazy {
  findViewById(viewId) as T
}

class MainActivity: Activity() {
  var questionLabelView: TextView by bindView(R.id.main_question_label)
}
