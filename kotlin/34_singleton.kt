// java
public class Singleton {
  private static Singleton instance = null;
  private Singleton() {

  }
  
  private synchronized static void createInstance() {
    if (instance == null)
      instance = new Singleton();
  }

  private static Singleton getInstance() {
    if (instance == null) createInstance();

    return instance;
  }
}

// kotlin 싱글콘을 생성하는 객체 선언(object declaration)
// class 키워드 대신 object키워드를 사용한다.
object Singleton

object SQLiteSingleton {
  fun getAllUsers(): List<User> {

  }
}
// 이 메소드는 다른 정적 자바 메소드와 같은 방법으로 이용할 수 있다.
SQLiteSingleton.getAllUsers()
