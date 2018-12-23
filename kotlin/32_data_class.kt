// data를 이용하여 equals hashCode 모든 메소드를 자동으로 생성할 수 있다.
// == 는 equals메소드가 호출된다.
data class Product(var name:String, var price:Double) 
	
fun main(args: Array<String>) {
    val productA = Product("Spoon", 30.2) 
    val productB = Product("Spoon", 30.2) 
    val productC = Product("Fork", 17.4)

    print(productA == productA) // true
    print(productA == productB) // true
    print(productB == productA) // true
    print(productA == productC) // false
    print(productB == productC) // false
    // toString 메소드
    print(productA) // Product(name=Spoon, price=30.2)

    // copy 메소드
    val productD = productA.copy()
    print(productD) // Product(name=Spoon, price=30.2)

    val productE = productA.copy(price = 24.0)
    print(productE) // Product(name=Spoon, price=24.0)

    val productF = Product("Doll", 100.0)
    var (name, price) = productF
    print(name) // Doll
    print(price) // 100.0
}

class Product(var name: String?, var price: Double?) {
  override fun hashCode(): Int {
    var result = if (name != null) name!!.hashCode() else 0
    result = 31 * result + if (price != null) price!!.hashCode()
    else 0
    return result
  }

  override fun equals(other: Any?): Boolean = when {
    this === other -> true
    other == null || other !is Product -> false
    if (name != null) name != other.name else other.name != null -> false
    else -> other.price == null
  }

  override fun toString(): String {
    return "Product(name=$name, price=$price)"
  }
}
