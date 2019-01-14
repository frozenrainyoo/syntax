// 위임 속성
class User(val name: String, val surname: String)

var user: User by UserDelegate()

println(user.name)
user = User("Marcin", "Moskala")
// user 속성을 (생서자에 의해 생성되는)UserDelegate의 인스턴스로 위임한다.
