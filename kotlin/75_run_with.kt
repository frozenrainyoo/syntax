val button = findViewById(R.id.button) as Button

button.apply {
  text = "Click me"
  isVisible = true
  setOnClickListener { }
}
button.run {
  text = "Click me"
  isVisible = true
  setOnClickListener { }
}
with(button) {
  text = "Click me"
  isVisible = true
  setOnClickListener { }
}

// apply, run, with 간의 차이점은 apply는 수신자 객체를 반환하며, run과 with는 함수 리터럴의
// 결과를 반환한다는 것이다.
val button = findViewById(R.id.button) as? Button

button?.run {
  text = "Click me"
  isVisible = true
  setOnClickListener { }
}

val button = findViewById(R.id.button) as Button
with(button) {
  text = "Click me"
  isVisible = true
  setOnClickListener { }
}
