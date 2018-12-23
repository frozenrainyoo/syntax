// ActivityTestRule가 제대로 초기화되지 않는다.
// JUnit이 인식하지 못하는 코틀린 속성에 애노테이션을 지정했다.
@Rule
val activityRule = ActivityTestRule(MainActivity::class.Java)

// 자바 필드로 노출하기 위해 JvmField를 사용한다.
// 해당 속성에 기반 필드가 있고, private가 아니며, open, override, const 한정자가 없고
// 위임된 속성이 아니어야 한다.
@JvmField @Rule
val activityRule = ActivityTestRule(MainActivity::class.Java)

// getter에 직접 애노테이션을 지정할 수 있다.
val activityRule
@Rule get() = ActivityTestRule(MainActivity::class.Java)

// getter에 애노테이션을 추가할 수 있다.
@get:Rule
val activityRule = ActivityTestRule(MainActivity::class.Java)
