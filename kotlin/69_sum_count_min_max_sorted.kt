
val sum = listOf(1, 2, 3, 4).sum()
print(sum) // 10

class User(val points: Int)
val users = listOf(User(10), User(1000), User(10000))
val points = users.map { it.points }.sum()
print(points) // 11010

val points = users.sumBy { it.points }
print(points) // 11010

class User(val points: Double)
val users = listOf(User(10.0), User(1000.0), User(10000.0))
val poins = users.sumByDouble { it.points }
println(points) // 11010.0

//////////////////////////////////////
val evens = (1..5).count { it % 2 == 1 }
val odds = (1..5).count {it % 2 == 0 }
print(evens) // 3
print(odds) // 2
val nums = (1..4).count()
print(nums) // 4

val list = listOf(4, 2, 5, 1)
print(list.min()) // 1
print(list.max()) // 5

val strs = listOf("kok", "ada", "bal", "mal")
print(strs.min()) // ada
print(strs.sorted()) // ada, bal, kok, mal

students.filter { it.passing }
  .sortedByDescending { it.grade }
  .take(3)
  .forEach(::println)

val minByLen = listOf("ppp", "z", "as")
  .mainBy { it.length }
println(minByLen) // z

val maxByLen = listOf("ppp", "z", "as")
  maxBy {it.length }
println(maxByLen) // ppp

//////////////////////////////////////
val comparator = Comparator<String> { e1, e2 ->
  e2.length - e1.length
}
val minByLen = listOf("ppp", "z", "as")
  .sortedWith(comparator)
print(minByLen) // ppp, as, z

// compareBy, compareByDescending를 제공한다.
data class User(val name: String, val surname: String) {
  override fun toString() = "$name $surname"
}
val users = listOf(
  User("A", "A"),
  User("B", "A"),
  User("B", "B"),
  User("A", "B")
)
val sortedUsers = users
  .sortedWith(compareBy({ it.surname }, { it.name }))
print(sortedUsers) // A A, B A, A B , B B

// 람다식 대신 속성 참조를 사용할 수 있다.
val sortedUsers = users
  .sortedWith(compareBy(User::surname, User::name))
print(sortedUsers) // A A, B A, A B, B B

//////////////////////////////////////
val grouped = listOf("ala", "alan", "mulan", "malan")
  .groupBy { it.first() }
print(grouped) // {'a' : ["ala", "alan"], 'm': ["mulan", "malan"]}

class Student(val name: String, val classCode: String, val meanGrade: Float)

val students = listOf(
  Student("Hommer", "1", 1.1F),
  Student("Carl", "2", 1.5F),
  Student("Donald", "2", 3.5F),
  Student("Alex", "3", 4.1F),
  Student("Marcin", "3", 5.0F),
  Student("Max", "1", 3.2F)
)

val bestInClass = students
  .groupBy { it.classCode }
  .max { (_, students) -> students.maxBy { it.meanGrade }!! }
  .map { it.name }
print(bestInClass) // [Max, Donald, Marcin]

// 이 밖의 스트림 처리 함수는 코틀린 공식 웹사이트에 잘 정리되어 있다.
// 안드로이드 스튜디오에서 command + 구현을 보려는 함수를 클릭하면 자세한 내용이 표시된다. 
