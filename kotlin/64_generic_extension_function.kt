
startActivity(Intent (this, SettingsActivity::class.java ))

// 간단하고 반복적인 작업이지만 코드가 이해하기 쉽지 않다.
// reified형식을 이용해 제네릭 인라인 확장 함수로 훨씬 간단하게 인텐트를 생성하고 액티비티를 시작할 수 있다.
inline fun <reified T: Any> Context.getIntent()
  = Intent(this, T::class.java)

inline fun <reified T: Any> Context.startActivity()
  = startActivity(getIntent<T>())

startActivity<SettingsActivity>()

// 위 공통적인 작업을 더 쉽게 처리할 수 있는 Anko 라이브러리
// https://github.com/Kotlin/anko
startActivity<SettingsActivity>(userKey to user)

// https://bithub.com/MarcinMoskala/ActivityStarter 이용
class StudentDataActivity: BaseActivity() {
  lateinit @Arg var student: Student
  @Arg(optional = true) var lesson: Lesson = Lesson.default()
}
StudentDataActivityStarter.start(context, student, lesson)

// 코틀린에서 확장함수와 인라인 한정자를 이용해 Gson을 이용해 객체를 JSON형식의 String으로
// 패킹 및 언패킹하는 확장 함수를 보여준다.
inline fun Any.toJson() = globalGson.toJson(this)!!

inline fun <refied T: Any> String.fromJson()
  = globalGson.fromJson(this, T::class.java)

// 사용법
var user = User("Marcin", "Moskala")
val json: String = user.toJson()
val userFromJson: User = json.fromJson<User>()

// * 최상위지만 객체에서 호출되므로 관리하기 편하다.
// * 제네릭이므로 범용적이며 모든 것에 적용할 수 있다.
// * 인라인으로 만들 경우 reified 형식 매개변수를 정의할 수 있다.
