// Model View Presenter

// KitlinAndroidViewBinding 라이브러리
// https://github.com/MarcinMoskala/KotlinAndroidViewBindings 에서 수준높은 구현을 볼 수 있다.

override fun getName(): String {
  return nameView.text.toString()
}
override fun setName(name: String) {
  nameView.text = name
}
interface MainView {
  fun getName(): String
  fun setName(name: String)
}

/// 속성 바인딩을 사용하면 앞에 나온 코드를 간소화해서 케터, 세터 메소드의 필요성을 줄이고, 속성을 뷰 요소에 바인딩할 수 있다.
override var name: String by bindToText(R.id.textView)

interface MainView {
  var name: String
}

https://github.com/MarcinMoskala/MarvelGallery
