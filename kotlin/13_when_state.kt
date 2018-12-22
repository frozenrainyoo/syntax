
// 자바의 switch .. case 문을 대체한 문법이다.
when (x) {
  1 -> print("x == 1")
  2 -> print("x == 2")
  else -> println("x is neither 1 nor 2")
}

{
  val vehicle = "Bike"
  val message = when (vehicle) {
    "Car" -> {
      "Four whells"
    }
    "Bike" -> {
      "Two wheels"
    }
    else -> {
      "Unknown number of wheels"
    }
  }
}

{
  val vehicle = "Car"
  when (vehicle) {
    "Car", "Bike" -> print("Vehicle")
    else -> print("Unidentified funny object")
  }
}

{
  val name = when (person) {
    is String -> person.toUpperCase() // String으로 스마트형변환되므로 String 메소드를 호출할 수 있다.
    is User -> person.name
  }
}

// major risk?
{
  val riskAssessment = 47
  val risk = when (riskAssessment) {
    in 1..20 -> "negligible risk"
    !in 21..40 -> "minor risk"
    !in 41..60 -> "major risk"
    else -> "undefined risk"
  }
}

fun main(args: Array<String>) {
    val large:Boolean = true 
         
    when(large){ 
        true -> println("Big") 
        false -> println("Big") 
    } 
}
