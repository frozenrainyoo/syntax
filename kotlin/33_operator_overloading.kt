// a + b : a.plus(b)
// a - b : a.minus(b)
// a * b : a.times(b)
// a / b : a.div(b)
// a % b : a.rem(b)
// a..b : a.rangeTo(b)
// a += b : a.plusAssign(b)
// a -= b : a.minusAssign(b)
// a *= b : a.timesAssign(b)
// a /= b : a.divAssign(b)
// a %= b : a.remAssign(b)
// a++ : a.inc()
// a-- : a.dec()
// a in b : b.contains(a)
// a !in b : !b.contains(a)
// a[i] : a.get(i)
// a[i, j] : a.get(i, j)
// a[i_1, ..., i_n] : a.get(i_1, ..., i_n)
// a[i] : b : a.set(i, b)
// a[i, j] : b : a.set(i, j, b)
// a[i_1, ..., i_n] : b : a.set(i_1, ..., i_n, b)
// a() : a.invoke()
// a(i) : a.invoke(i)
// a(i, j) : a.invoke(i, j)
// a(i_1, ..., i_n) : a.invoke(i_1, ..., i_n)
// a == b : a?.equals(b) ?: (b === null)
// a != b : !(a?.equals(b) ?: (b === null))
// a > b : a.compareTo(b) > 0
// a < b : a.compareTo(b) < 0
// a >= b : a.compareTo(b) >= 0
// a <= b : a.compareTo(b) <= 0

data class Point(var x: Double, var y: Double) {
  operator fun plus(point: Point) = Point(x + point.x, y + point.y)
  operator fun times(other: Int) = Point(x * other, y * other)
}

var p1 = Point(2.9, 5.0)
var p2 = Point(2.0, 7.5)

print(p1 + p2) // Point(x=4.9, y=12.5)  // 내부적으로 p1.plus(p2) 호출
print(p1 * 3) // Point(x=8.7, y=15.0)  // 내부적으로 p1.times(3) 호출
