val str = "abcd"
str.reversed() // dcba
str.takeLast(2) // cd
"john@test.com".substringBefore("@") // john
"john@test.com".startWith("@") // false

val name = "Eva"
val age = 27
val message = "My name is $name and I am $age years old"
val message = "My name has ${name.length} characters" // 3
