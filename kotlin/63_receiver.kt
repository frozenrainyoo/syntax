class MainActivity: Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    val buttonView = fundViewById(R.id.button_view) as Button
    buttonView.setUp()
  }

  private fun Button.setUp() {
    setText("Click me!") // extension receiver : Button
    setOnClickListener {
      showText("Hello") // dispatch receiver : MainActivity
      setText("Hello!!") // 같은 이름의 메소드가 있으면 extension receiver가 우선순위 위다.
      this@MainActivity.setText("Hello!!") // receiver를 구분할 수 있다.
    }
  }

  private fun setText(text: String) {
    textView.setText(text)
  }
  private fun showText(text: String) {
    toast(text)
  }
}
