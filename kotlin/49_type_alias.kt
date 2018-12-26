data class User(val name: String, val surname: String)
typealias Users = List<User>

typealias Weight = Double
typealias Length = Int
val weight: Weight = 52.0
val length: Length = 34

// 최상위에 선언해야 한다.
// 기본 한정자는 public이다. 변경가능하다.
typealias Length = Int
var intLength: Int = 17
val length: Length = intLength
intLength = length

///////////////////////////////////////////////
// 긴 제네릭 형식을 단축하고 이해하기 쉬운 이름을 지정
typealias Dictionary<V> = Map<String, V>
typealias Array2D<T> = Array<Array<T>>

///////////////////////////////////////////////
// 함수 형식에 이름을 지정하는데 사용
typealias Action<T> = (T) -> Unit
typealias CustomHandler = (Int, String, Any) -> Unit

///////////////////////////////////////////////
// 함수 형식 매개변수 이름을 함께 사용
typealias OnElementClicked = (position: Int, view: View, parent: View)->Unit

class MainActivity: Activity(), OnElementClicked {
  override fun invoke(position: Int, view: View, parent: View) {
    // code ..
  }
}
