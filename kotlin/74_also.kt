abstract class Provider<T> {
  var original: T? = null
  var override: T? = null

  abstract fun create(): T

  fun get(): T = override ?: original ?: create().also {
    original = it
  }
}

fun makeHttpClient(vararg interceptors: Interceptor) =
  OkHttpClient.Builder()
    .connectItmeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .also { it.interceptors().addAll(interceptors) }
    .build()

////////////////////
// 이미 확장 함수 안에 있으면서 다른 확장 수신자를 추가하고 싶지 않을 때도 also함수가 유용하다.
class Snail {
  var name: String = ""
  var type: String = ""
  fun greet() {
    println("Hello, I am $name")
  }
}

class Forest {
  var members = listOf<Snail>()
  fun Snail.reproduce(): Snail = Snail().also {
    it.name = name
    it.type = type
    members += it
  }
}
