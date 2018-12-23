
enum class Color {
  RED,
  ORANGE,
  BLUE,
  GRAY,
  VIOLET
}

val favouriteColor = Color.BLUE

// 문자열을 enum으로 바꾸려면 valueOf를 사용
val selectedColor = Color.valueOf("BLUE")
print(selectedColor == Color.BLUE) // true

// 또는 enumValueOf 사용
val selectedColor = enumValueOf<Color>("BLUE")
print(selectedColor == Color.BLUE) // true

for (color in Color.values()) {
  print("name: ${it.name}, ordinal: ${it.ordinal}")
}
for (color in enumValues<Color>()) {
  print("name: ${it.name}, ordinal: ${it.ordinal}")
}
// name: RED, ordinal: 0
// name: ORANGE, ordinal: 1
// name: BLUE, ordinal: 2
// name: GRAY, ordinal: 3
// name: VIOLET, ordinal: 4

enum class Temperature { COLD, NEUTRAL, WARM }
enum class Color(val r: Int, val g: Int, val b: Int) {
  RED(255, 0, 0) {
    override val temperature = Temperature.WARM
  },
  ORANGE(255, 165, 0) {
    override val temperature = Temperature.WARM
  },
  BLUE(0, 0, 255) {
    override val temperature = Temperature.COLD
  },
  GRAY(49, 79, 79) {
    override val temperature = Temperature.NEUTRAL
  },
  VIOLET(238, 130, 238) {
    override val temperature = Temperature.COLD
  }; // ; 세미콜론은 상수 정의와 멤버 정의를 분리하는 역할을 한다.

  init {
    require(r in 0..255)
    require(g in 0..255)
    require(b in 0..255)
  }

//  fun rgb() = r shl 16 + g shl 8 + b
  fun rgb() = (r * 256 + g) * 256 + b

  abstract val temperature: Temperature
}

fun printHex(num: Int) {
  println(num.toString(16))
}

printHex(Color.BLUE.rgb()) // ff
printHex(Color.ORANGE.rgb()) // ffa500
printHex(Color.GRAY.rgb()) // 314f4f
print(Color.BLUE.temperature) // COLD
print(Color.ORANGE.temperature) // WARM
print(Color.GRAY.temperature) // NEUTRAL
