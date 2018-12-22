// 불안 형변환 unsafe cast 연산자를 나타내는 as 키워드가 있다.
val fragment: Fragment = ProductFragment()
val productFragment: ProductFragment = fragment as ProductFragment

// 안전 형변환 safe cast 연산자를 나타내는 as? 키워드가 있다.
val fragment: String = "ProductFragment"
val productFragment: ProductFragment? = fragment as? ProductFragment

// Error ClassCastException
val fragment: String = "ProductFragment"
val productFragment: ProductFragment = fragment as ProductFragment // Error ClassCastException

val name: String
val age: Int = 12
name = age.toString() // Int를 String으로 변환 

// ** 스마트 형변환 **
// 한 변수 형식을 다른 형식으로 변환하지만, 아전 형변환과는 다르게 암시적으로 변환을 수행한다.
// 스마트 형변환은 코틀린 컴파일러가 검사한 후에도 변수가 변하지 않는다는 것을 확신하는 경우에만 작동한다.
// 따라서 다중 스레드 애플리케이션에서도 완전히 안전하다.
// 자바 
if (animal instanceof Fish) {
  Fish fish = (Fish)animal;
  fish.isHungry();
  // 또는
  ((Fish) animal).isHungry();
}

// 코틀린
if (animal is Fish) {
  animal.isHungry()
}
// 코틀린 컴파일러는 형식을 검사한 후 암시적으로 형변환을 수행할 수 있으므로 animal인스턴스를 명시적으로
// Fish로 형변환할 필요가 없다. 그 결과 자바 예제와 완전히 동일하다. 스마트 형변환의 유효범위는 if 블록으로 제한된다.

// 아래는 if 문 이후로 암시적으로 null 불허 Fish로 변환된다.
val fish:Fish? = // ...
if (animal !is Fish)
  return

animal.isHungry()


if (animal is Fish && animal.isHungry()) {
  println("Fish is hungry")
}

// null 가능성 스마트 형변환
val view: View? = findViewById(R.layout.activity_shop)
{
  val view: View?
  if (view != null) {
    view.isShown()
    // view가 if블록 안에서 null 불허로 형변환된다.
  }

  view.isShown() // if블록 밖에서는 view가 null 허용이다.
}

fun setView(view: View?) {
  if (view == null)
    return
  // view가 null 불허로 형변환된다.
  view.isShown()
}

// 엘비스 연산자를 사용하고 null 검사를 하면 위의 구문을 더 간단하게 만들 수 있다.
fun verifyView(view: View?) {
  view ?: return

  // view가 null 불허로 형변환된다.
  view.isShown()
}

fun setView(view: View?) {
  view ?: throw RuntimeException("View is empty")
  // view가 null 불허로 형변환된다.
  view.isShown()
}
