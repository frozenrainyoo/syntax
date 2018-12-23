// Companion Object
// 싱글톤 객체가 동일한 이름의 클래스와 연결되는 경우 이 객체를 컴패니언 객체라 한다.
// 여기에 연결된 클래스를 컴패니언 클래스라고 한다.
class ProductDetailsActivity {
  companion object {

  }
}

// ProductDetailsActivity.kt
class ProductDetailsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val product = intent.getParcelableExtra<Product>
      (KEY_PRODUCT)
  }

  companion object {
    const val KEY_PRODUCT = "product"

    fun start(context: Context, product: Product) {
      val intent = Intent(context, ProductDetailsActivity::class.java)
      intent.putExtra(KEY_PRODUCT, product)
      context.startActivity(intent)
    }
  }
}

// activity를 시작한다.
ViewProductActivity.start(context, productId)

// Car 예제
class Car {
  init {
    count++
  }

  companion object {
    var count: Int = 0
    private set
  }
}

println(Car.count) // 0
Car()
Car()
println(Car.count) // 2

// 컴패니언 객체의 인스턴스 생성
class Car {
  init {
    count++
    print("Car created")
  }

  companion object {
    var count: int = 0
    init {
      print("Car companion object created")
    }
  }
}

{
  Car.count // Car companion object created
  Car() // Car created
}

{
  Car() // Car companion object created
        // Car created
  Car() // Car created
  Car.count
}

// 컴패니언 객체도 함수를 포함하고, 인터페이스를 구현하며, 클래스를 확장할 수도 있다.
// 테스트를 위해 재정의 구현을 제공할 수 있는 정적 생성 메소드를 포함하는 컴패니언 객체를 정의할 수 있다.
abstract class Provider<T> { // Provider 제네릭 클래스
  abstract fun create(): T // 인스턴스를 생성하는 추상함수
  private var instance: T? = null // 생성된 인스턴스를 저장하는 필드
  var override: T? = null // 인스턴스의 대체 구현을 제공하며 테스트에 사용되는 필드
  
  // override 인스턴스가 설정된 경우 이를 반환하고, 인스턴스가 생성된 경우 이를 반환하거나 생성 메소드를
  // 이용해 인스턴스를 생성하고 필드를 채우는 함수
  fun get(): T = override ?: instance ?: create().also {
    instance = it
  }
}

interface MarvelRepository {
  fun getAllCharacters(searchQuery: String?): Single<List<MarvelCharacter>>

  companion object : Provider<MarvelCharacter>() {
    override fun creator() = MarvelRepositoryImpl()
  }
}

// 인스턴스를 얻으려면 다음과 같이 한다.
MarvelRepository.get()
