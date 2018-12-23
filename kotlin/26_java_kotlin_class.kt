// Java
public class Fish {
  private int size;
  private boolean hungry;

  public Fish(int size, boolean isHungry) {
    this.size = size;
    this.hungry = isHungry;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size
  }

  public boolean isHungry() {
    return hungry;
  }

  public void setHungry(boolean hungry) {
    this.hungry = hungry;
  }
}

// 코틀린에서 클래스 사용
val fish = Fish(12, true)
fish.size = 7
println(fish.size) // 7
fish.isHungry = true
println(fish.isHungry) // true


// 코틀린에서 클래스 선언
class Fish(var size: Int, var hungry: Boolean)

// 자바에서 클래스 사용
Fish fish = new Fish(12, true);
fish.setSize(7);
System.out.println(fish.getSize());
fish.setHungry(false);
System.out.println(fish.getHungry());
