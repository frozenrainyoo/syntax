
val mountain = "Everest";
var pair = mountain.to(8848)
print(pair.first) // Everest
print(pair.second) // 8848

// 중위 메소드를 포함하여 사용하는 방법
data class Point(val x: Int, val y: Int) {
  infix fun moveRight(shift: Int) = Point(x + shift, y)
}

val pointA = Point(1, 4)
val pointB = pointA moveRight 2
print(pointB) // Point(x=3, y=4)

// Card 예제
enum class Suit {
  HEARTS,
  SPADES,
  CLUBS,
  DIAMONDS
}

// 특정 계급과 슈트로 구성된 카드를 나타내는 클래스
data class Card(val rank: Rank, val suit: Suit)

enum class Rank {
  TWO, THREE, FOUR, FIVE,
  SIX, SEVEN, EIGHT, NINE,
  TEN, JACK, QUEEN, KING, ACE;

  infix fun of(suit: Suit) = Card(this, suit)
}

val card = Rank.KING of Suit.HEARTS
val card = Rank.KING.of(Suit.HEARTS)

// 가장 간단하게 하는 방법
import Rank.KING
import Suit.HEARTS
val card = KING of HEARTS
