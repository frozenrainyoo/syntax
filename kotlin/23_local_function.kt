
fun printTwoThreeTimes() {
  fun printThree() {
    print(3)
  }
  printThree()
  printThree()
}

fun makeStudentList(): List<Student> {
  var students: List<Student> = emptyList()
  fun addStudent(name: String, state: Student.State = Student.State.New) {
    students += Student(name, state, courses = emptyList())
  }
  addStudent("one")
  addStudent("two")
}
