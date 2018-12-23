
class Fruit(var weight: Double) { 
    var ecoRating: Int = 3 
    get() { 
        println("getter value retrieved") 
        return field 
    } 
    set(value) { 
        field = if (value < 0) 0 else value 
        println("setter new value assigned $field") 
    } 
}
	
fun main(args: Array<String>) {
    val fruit = Fruit(12.0) 
    val ecoRating = fruit.ecoRating 
    fruit.ecoRating = 3 // setter new value assigned 3
    fruit.ecoRating = -5 // setter new value assigned 0
}

class Apple(var weight: Double, val fresh: Boolean) {
  var isHeavy = weight > 20
  var ecoRating: Int = when(weight) {
    in 0.5..2.0 -> 5
    in 0.4..0.5 -> 4
    in 0.3..0.4 -> 3
    in 0.2..0.3 -> 2
    else -> 1
  }
}
