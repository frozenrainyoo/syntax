// 위임 패턴 delegation pattern 
// 위임은 객체가 클래스를 확장하는대신 요청을 다른 객체(대리자)로 위임해 처리하는 것을 의미한다.
interface Player {
  fun playGame()
}
class RpgGamePlayer(val enemy: String) : Player {
  override fun playGame() {
    println("Killing $enemy")
  }
}
class WitcherPlayer(enmey: String) : Player {
  val player = RpgGamePlayer(enmey)
  override fun playGmae() {
    player.playGame()
  }
}
RpgGamePlayer("monsters").playGame() // Killing monsters
WitcherPlayer("monsters").playGame() // Killing monsters


/////////////////////////////////
class WitcherPlayer(enemy: String) : Player {
  val player = RpgGamePlayer(enmey)
  override fun playGame() {
    player.playGame()
  }
}

class WitcherPlayer() : RpgGamePlayer()

// 위 위임을 코틀린으로 아주 간단하게 구현할 수 있게 해준다.
class WitcherPlayer(enemy: String) : Player by RpgGamePlayer(enemy) {}
// by 키워드를 사용하여 Player인터페이스에 정의된 모든 메소드를 WitcherPlayer에서 
// RpgGamePlayer로 위임하도록 컴파일러에 지시할 수 있다.
// WitcherPlayer는 Player인터페이스에 정의된 메소드를 새로운 RpgGamePlayer객체로 위임한다.
// 이 방식의 큰 장점은 직접 메소드를 구현할 필요가 없다는 것이다. 



class WitcherPlayer(player: Player) : Player by player

// 생성자에 정의된 속성으로 위임할 수 있다.
class WitcherPlayer(val player: Player) : Player by player

// 클래스 선언 중에 접근 가능한 모든 속성으로 위임할 수 있다.
val d = RpgGamePlayer(10)
class WitcherPlayer(a: Player) : Player by d


// 한 객체가 여러 다른 대리자를 가질 수 있다. 
interface Player {
  fun playGame()
}

interface GameMaker {
  fun developGame()
}

class WitcherPlayer(val enemy: String) : Player {
  override fun playGame() {
    print("Killing $enemy! ")
  }
}

class WitcherCreator(val gameName: String) : GameMaker {
  override fun developGame() {
    print("Makin $gameName")
  }
}

class WitcherPassionate :
  Player by WitcherPlayer("monsters"),
  GameMaker by WitcherCreator("Witcher 3") {

    fun fulfillYourDestiny() {
      playGame()
      developGame()
    }
}

WitcherPassionate().fulfillYourDestiny() // Kiilin monsters! Makin Witcher 3!


// * 하위 클래스가 리스코프 치환원칙 Liskov substitution principle을 위반하는 경우, 예를 들어
// 상속을 제대로 고려하지 않고 단순하게 상위 클래스의 코드를 재사용하기 위해 상속을 구현하는 경우가 해당된다.
// * 하위 클래스가 상위 클래스의 메소드 중 일부만 사용하는 경우, 이 경우 상위 클래스에서 호출하지 말아야 할
// 메소드가 호출되는 것은 시간 문제다. 위임을 사용하면 선택한 메소드만 재사용한다.
// * 다음과 같은 이유로 상속을 사용할 수 업석나 사용하지 않아야 하는 경우
//  클래스가 final이다. 접근할 수 없으며 인터페이스뒤로 숨겨져 있다., 상속하도록 설계되지 않았다.

// 리스코프 치환원칙은 모든 하위 클래스가 상위 클래스처럼 작동해야 한다고 규정하는 OOP의 개념이다.
// 간단히 말해, 어떤 클래스에 대한 단위 테스트가 통과했다면 그 하위 클래스에 대해서도 테스트가 통과해야 한다.
// 이 원칙은 로버트 C 마틴이 그의 유명한 저서 "클린 코드"에서 OOP의 가장 중요한 규칙으로 소개하고 설명하면서
// 널리 알려졌다.
