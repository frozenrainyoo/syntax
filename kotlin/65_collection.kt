
data class Student(
  val name: String,
  val grade: Double,
  val passing: Boolean
)

val students = listOf(
  Student("John", 4.2, true),
  Student("Bill", 3.5, true),
  Student("John", 3.2, false),
  Student("Aron", 4.3, true),
  Student("Jimmy", 3.1, true)
)

// imperative approach
val filteredList = ArrayList<Student>()
for (student in students) {
  if (student.passing)
    filteredList += student
}

Collections.sort(filteredList) { p1, p2 ->
  if (p1.grade > p2.grade) -1 else 1
}
for (i in 0..2) {
  val student = filteredList[i]
  println(student)
}
// Student(name=Aron, grade=4.3, passing=true)
// Student(name=John, grade=4.2, passing=true)
// Student(name=Bill, grade=3.5, passing=true)

// 코틀린의 스트림 처리를 이용해 훨씬 간단한 방법으로 같은 결과를 얻을 수 있다.
student.filter { it.passing } // 합격한 학생만 받는다
  .sortedByDescending { it.grade } // 성적에 따라 학생을 정렬한다. 내림차순
  .take(3) // 처음 세 명의 학생을 받는다.
  .forEach(::println) // 학생을 출력한다.
