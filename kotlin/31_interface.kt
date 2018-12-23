
interface EmailProvider {
  val email: String

  val nickname: String
  get() = email.substringBefore("@")

  fun validateEmail() = nickname.isNotEmpty()
}

class User:EmailProvider {
  override val email: String = "UserEmailProvider"
  override fun validateEmail {
  }
}

// 매개변수를 재정의하는 데 사용할 수 있다.
class User(override val email: String) : EmailProvider {
  override fun validateEmail() {
  }
}

class User(override val email: String) : EmailProvider

fun main(args: Array<String>) {
  val user = User("justin@gmail.com")
  print(user.nickname) // justin
  print(user.validateEmail()) // true
}

open class Person {
  interface EmailProvider {
    fun validateEmail()
  }

  class User: Person(), EmailProvider {
    override fun validateEmail() {

    }
  }
}

// multiple interface
    interface A { 
        fun foo() { 
            println("A") 
        } 
    } 
 
    interface B { 
        fun foo() { 
            println("B") 
        } 
    } 
	class Item : A, B { 
        override fun foo() { 
            val a = super<A>.foo()
            val b = super<B>.foo()
            println("Item $a $b") 
        } 
    } 
	
fun main(args: Array<String>) {
	val item = Item() 
    item.foo() 
    // A
    // B
    // Item A B
}
