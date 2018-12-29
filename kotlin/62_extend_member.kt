class UserItemAdapter : ItemAdapter() {
  lateinit var userNames: List<String>

  fun processList() {
    userNames = getUsersList()
      .map { it.name }
      .dropOneEvery(3)
  }

  fun List<String>.dropOneEvery(i: Int) =
    filterIndexed { index, _ -> index % i == ( i - 1 ) }
}

// 멤버 확장 함수를 사용하는 첫 번째 이유는 함수의 접근성을 보호하기 위해서다.

// private 속성 category를 이용
class UsersItemAdapter(
  private val category: Category
): ItemAdapter() {
  lateinit var usersNames: List<String>

  fun processList() {
    usersNames = getUsersList()
      .fromSameCategory()
      .map { it.name }
  }

  fun List<User>.fromSameCategory() =
    filter { u -> u.category.id == category.id }

  private fun getUsersList() = emptyList<User>()
}

// 멤버 확장 함수 fromSameCategory 안에서 확장 수신자 (ListUser>)를 상대로 작업하지만, 
// UsersItemAdapter의 category속성도 이용한다. 

// fromeSameCategory가 표준 메소드로 정의된 경우
userNames = fromSameCategory(newUsers)
  .dropLast(3)

// fromSameCategory가 멤버확장 함수로 정의된 경우
userNames = newUsers.fromSameCategory().dropLast(3)
