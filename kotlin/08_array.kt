val array = arrayOf(1, 2, 3) // 유추 형식은 Array<Int>

// 기본적으로 Int의 배열로 생성한다. Short, Long을 포함하는 배열을 만드려면 명시적으로 지정해야 한다.
val array2: Array<Short> = arrayOf(1, 2, 3)
val array3: Array<Long> = arrayOf(1, 2, 3)

// 위 코드처럼 박싱된 표현을 사용하면 애플리케이션의 성능이 저하될 수 있다.
// 이 때문에 코틀린은 박싱 메모리 오버헤드를 줄일 수 있는 기본형의 배열을 나타내는 몇가지 특수한 클래스
// ShortArray, IntArray, LongArray를 제공한다.
var array = shortArrayOf(1, 2, 3)
var array = intArrayOf(1, 2, 3)
var array = longArrayOf(1, 2, 3)

// 배열의 정확한 크기를 알 수 있으면 성능이 개선되므로 null로 채운 배열을 생성하는 함수가 있다.
val array = arrayOfNulls(3) // 출력 [null, null, null]

// 배열 크기를 첫 번째 매개변수로 받고 주어진 인덱스의 각 배열 요소의 초깃값을 반환할 수 있는 람
// 다를 두 번째 매개변수로 받는 팩토리 함수를 사용해 미리 정의된 크기의 배열을 채울 수 있다.
val array = Array (5) {it * 2} // 출력 : [0, 2, 4, 8, 10]

// 배열 요소에 접근하는 방법은 자바와 동일하다.
val array = arrayOf(1, 2, 3)
println(array[1]) // 출력: 2
