// 코틀린의 자바 SAM 지원 / 함수형 인터페이스
// Single Abstract Method
// 자바
button.setOnClickListener(new OnClickListener() {
  @Override public void onClick(View v) {

  }
});

// setOnClickListener 메소드는 onClick 메소드 하나만 포함하므로 SAM이다.
button.setOnClickListener(OnClickListener {

})

// 더 간단하게 아래처럼 사용할 수 있다.
button.setOnClickListener {

}

///////////////////////////////////////////////
// 함수 리터럴(function literal)은 명명되지 않은 함수를 정의하는 식이다. 코틀린에는 두 가지 종류의 함수 리터럴이 있다.
// 1. 익명함수 val a = fun() {}
// 2. 람다식  val b = {}

///////////////////////////////////////////////
// 코틀린으로 작성한 함수에 SAM이 포함되는 경우 자바 메소드처럼 사용할 수 없다.
interface OnClick {
  fun call()
}
fun setOnClick(onClick: OnClick) {

}
setOnClick { } // Error
// 코틀린에서는 함수형식으로 사용하자.
fun setOnClick(onclick: () -> Unit) {

}
setOnClick { } // OK

///////////////////////////////////////////////
// 예제
view.setOnLongClickListener { ... }
view.onFocusChange { view, b -> ... }
val callback = Runnable { ... }
view.postDelayed(callback, 1000)
view.removeCallbacks(callback)

//RxJava
observable.doOnNext { ... }
observable.doOnEach { ... }
