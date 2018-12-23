// sealed class 봉인 클래스
// 하위 클래스의 수가 제한된 클래스다.
// 모든 클래스는 서로 가까운 위치에 선언되므로 한 파일만 보면 가능한 모든 하위 클래스를 볼 수 있다.

// vehicle.kt
// Vehicle은 Car, Truck, Bus클래스로만 확장될 수 있다.
sealed class Vehicle()
class Car : Vehicle()
class Truck : Vehicle()
class Bus : Vehicle()

//sealed class 는 when 문과 잘 어울린다.
when (vehicle) {
  is Car -> print("Car")
  is Truck -> print("Truck")
  is Bus -> print("Bus")
}
