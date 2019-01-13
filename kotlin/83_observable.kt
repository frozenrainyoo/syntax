// observable
var name: String by Delegates.observable("Empty") {
  property, oldValue, newValue ->
  println("$oldValue -> $newValue")
}

name = "Martin" // Empty -> Martin
name = "Igor" // Martin -> Igor
name = "Igor" // Igor -> Igor
