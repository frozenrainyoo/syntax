// 자바의 숫자 기본형과 동일하다.

형식     비트 수
Double  64
Float   32
Long    64
Int     32
Short   16
Byte    8

// 코틀린은 작은 형식이 암시적으로 큰 형식으로 캐스팅되지 않는다.
var weight: Int = 12
var truckWeight: Long = weight // Error

// 모든 것이 객체이므로 메소드를 호출해 int 형식을 명시적으로 Long으로 변환하면 문제가 해결된다.
var weight:Int = 12
var truckWeight: Long = weight.toLong() // Ok

toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char

// 리터럴을 지정해 유추되는 변수 형식을 변경 가능하다.
a = 1 // 10진수
a = 1L // Long
a = 0x1B // 16진수
a = 0b1101  // 2진수
a = 1.5 // Double
a = 1.5F // Float
