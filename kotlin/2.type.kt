
var title: String
var title // Error 타입을 유추할 수 없을 경우 에러 발생 

var title: String = "Kotlin"
// Type 생략 가능
var title = "Kotlin"

// Type을 생략했더라도 유추된 형식은 String으로 Int형을 할당할 수 없다.
var title = "kotlin"
title = 12 // Error

// Int를 title에 할당하려면 String과 Int의 공통 형식으로 지정해야 한다. 형식계층에서 가장 가까운 형으로 Any가 있다.
// String과 Int의 부모 클래스라고 생각하면 될 듯.
var title: Any = "Kotlin"
title = 12

// 아래 total은 어떤 타입으로 유추되는지 알기 힘들다..Int, Double, Float?
// macOS: Shift + Control + P
var total = sum(10, 20)

var persons = listOf(personInstance1, personInstance2)
// 유추된 형식: List<Person> ()

var pair = "Everest" to 8848
// 유추된 형식: Pair<String, Int>

var map = mapOf("Mount Everest" to 8848, "K2" to 4017)
// 유추된 형식: Map<String, Int>

var map = mapOf("Mount Everest" to 8848, "K2" to "4017")
// 유추된 형식: Map<String, Any>


var age: Int = 18

// 정수를 다룰 때는 Int형식이 기본으로 선택되지만, Short를 선택해 메모리를 절약할 수 있다.
var age: Short = 18

var age: Long = 18 // 명시적으로 포맷 선언 
var age = 18L // 리터럴 상수로 값 형식 지정  
