// reified 형식 매개변수
// 런타임에 형식 매개변수에 접근해야 하는 경우도 있지만 형식 삭제 때문에 불가능하다.
fun <T> typeCheck(s: Any) {
  if (s is T) {
    // Error
    println("same types")
  } else {
    println("different types")
  }
}

// 코틀린은 JVM의 제한을 극복하기 위해 런타임에 형식 인수를 보존하는 reified라는 한정자를 지원한다.
interface View
class ProfileView: View
class HomeView: View
inline fun <reified T> typeCheck(s: Any) {
  if (s is T) {
    println("same types")
  } else {
    println("different types")
  }
}

// 사용법
typeCheck<ProfileView>(ProfileView()) // same types
typeCheck<HomeView>(ProfileView()) // different types
typeCheck<View>(ProfileView()) // same types
