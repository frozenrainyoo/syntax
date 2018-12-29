// 코틀린에서 제네릭 혀식의 하위 형식 관계는 co-variant, contra-variant, invariant 할 수 있다.
// 유지, 반전, 무시
// invariant 
public class Box<T> { }
fun sum(list: Box<Number>) { }

sum(Box<Any>()) // Error
sum(Box<Number>()) // Ok
sum(Box<Int>()) // Error

/////////////////////////////////////////////
// co-variant
class Box<T>
// kotlin
fun sum(list: Box<out Number>) { }
// Java
public void sum(Box<? extends Number> list) { }

sum(Box<Any>()) // Error
sum(Box<Number>()) // OK
sum(Box<Int>()) // OK

/////////////////////////////////////////////
// contra-variance
class Box<T>
// kotlin
fun sum(list: Box<in Number>) { }
// Java
public void sum(Box<? super Number> list) { }

sum(Box<Any>()) // OK
sum(Box<Number>()) // OK
sum(Box<Int>()) // Error

/////////////////////////////////////////////
