
// NullPointerException 예방 
val age: Int = null // Error
var name: String? = null // Ok
// ? 접미사를 이용해 null을 허용한다고 지정했다.

val name: String? = null
name.toUpperCase() // Error 
// 형식선언           리스트 자체 null 허용,    요소 null 허용
ArrayList<Int>  //  No                      No
ArrayList<Int>? //  Yes                     No
ArrayList<Int?> //  No                      Yes
ArrayList<Int?>?//  Yes                     Yes

// 안전호출 
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val locked: Boolean? = savedInstanceState?.getBoolean("locked")
}

// 엘비스 연산자 
// 첫 번째 피연산자 ?: 두 번째 피연산자 
// 첫 번째 피연산자가 null이 아닌 경우 이 피연산자가 반환, 그렇지 않으면 두 번째 피연산자가 반환한다.
val locked: Boolean = savedInstanceState?.getBoolean("locked") ?: false

val correct = quiz.currentQuestion?.answer?.correct ?: false


// not-null 주장 
// !! 는 null 허용 변수를 명시적으로 null 불허 변수로 형변환한다.
var y: String? = "foo"
var size: Int = y!!.length

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val locked: Boolean = savedInstanceState!!.getBoolean("locked")
}
// 위코드는 NullPointerException이 발생할 수 있다.
// !!는 꼭 필요할 때만 사용하고, 대부분의 경우 안전 호출이나 스마트 형변환으로 대체해야 한다.

// let
// null 허용 변수를 다루기 위한 또 다른 기능으로 let이 있다. let은 함수이며
// let과 안전 호출 연산자를 결합한 구문의 예를 살펴보자.
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    savedInstanceState?.let{
        println(it.getBoolean("isLocked"))
    }
}


// 플랫폼 형식 
// 플랫폼 형식을 모두 null 허용으로 취급할 수 있지만, null 가능성은 일반적으로 상황에 따라 다르므로 종종 null 불허 변수로 취급할 수 있다.
// 다음 의사 코드는 플랫폼 형식의 가능한 의미를 보여준다.
T! = T or T?

var textView = findViewById(R.id.textView) as TextView

var textView = findViewById(R.id.textView) as TextView?
// 일부 레이아웃에만 존재할 때 사용.(가로 구성에만 존재)


