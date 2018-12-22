// variable
// string
// object
// function
// loop
// comparison
// conditional
// callback
// boolean
// array

// var - 가변 참조
fun main(args: Array<String>) {
    var fruit:String = "orange"
    fruit = "banana"
}

// val - 불변 변수 (like final)
fun main(args: Array<String>) {
    val fruit:String = "orange"
    fruit = "banana" // Error
}

// val는 특정 객체 인스턴스를 가리키는 참조를 바꿀 수 없지만, 참조된 객체의 상태는 변경할 수 있다.
val list = mutableListOf("a", "b", "c")
list = mutableListOf("d", "e") // Error
list.remove("a") // Ok

//변수/값정의                     참조변경가능    객체상태 변경가능
val = listOf(1, 2, 3)        // No           No
val = mutableListOf(1, 2, 3) // No           Yes
var = listOf(1, 2, 3)        // Yes          No
var = mutableListOf(1, 2, 3) // Yes          Yes
