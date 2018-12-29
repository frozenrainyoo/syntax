
var power: Int.(Int) -> Int

power = { n -> (1..n).fold(1) { acc, _ -> this * aac } }

// 익명 확장 함수로 power를 정의
power = { fun Int.(n: Int) = (1..n).fold(1) { acc, _ -> this * acc } }

val result = 10.power(3)
print(result) // 1000

//////////////////////////////
fun ViewGroup.addTextView(configure: TextView.()->Unit) {
  val view = TextView(context)
  view.configure()
  addView(view)
}

// 사용법
val linearLayout = findViewById(R.id.contentPanel) as LinearLayout
linearLayout.addTextView {
  text = "Marcin"
  textSize = 12F
}
