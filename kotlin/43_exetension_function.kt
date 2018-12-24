/////////////////////////////////////////////////////////////////////
abstract class A
class B: A()

fun A.foo() {
    println("foo(a)")
}

fun B.foo() {
    println("foo(b)")
}

fun main(args: Array<String>) {
    val b = B()
    b.foo() // foo(b)
    (b as A).foo() // foo(a)
    val a: A = b
    a.foo() // foo(a)
}