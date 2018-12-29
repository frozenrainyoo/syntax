val list = listOf(1, 2, 3).map { it * 2 }
println(list) // 2, 4, 6

val list = listOf(1, 2, 3, 4, 5).map { it > 2 }
println(list) // 3, 4, 5

val list = listOf(10, 20).flatMap { listOf(it, it + 1, it + 2) }
println(list) // 10, 11, 12, 20, 21, 22

shops.flatMap { it.products }
schools.flatMap { it.students }

students.filter { it.passing }
  .map { "${it.name} ${it.surname}" }

////////////////////////////////////////////////
inline fun <T, R> Iterable<T>.map(transform: (T) -> R):
List<R> {
  val destination = ArrayList<R>()
  for (item in this) destination.add(transform(item))
  return destination
}

inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean):
List<T> {
  val destination = ArrayList<T>()
  for (item in this) if (predicate(item)) destination.add(item)
  return destination
}

inline fun <T, R> Iterable<T>.flatMap(transform: (T) -> Collection<R>):
List<R> {
  val destination = ArrayList<R>()
  for (item in this) destination.addAll(transform(item))
  return destination
}
