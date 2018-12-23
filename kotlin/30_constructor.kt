class Fruit(val weight: Int) {
  constructor(weight: Int fresh: Boolean) : this(weight) { }
}

class Fruit(val weight: Int) {
  constructor(weight: Int, fresh: Boolean) : this(weight)
  constructor(weight: Int, fresh: Boolean) : this(weight, fresh)
}

class ProductView : View {
  constructor(ctx: Context) : super(ctx)
  constructor(ctx: Context, attrs: AttrivuteSet) : super(ctx, attrs)
}

class Fruit(name:String) // getter 생성 안 됨, setter 생성 안 됨, 생성자 매개변수
class Fruit(val name: String) // getter 생성 됨, setter 생성 안 됨, 속성
class Fruit(var name: String) // getter 생성됨, setter 생성 됨, 속성

// 점층적 생성자 패턴 Telescoping constructor pattern
val view1 = View(context)
val view2 = View(context, attributeSet)
val view3 = View(context, attributeSet, defStyleAttr)

// JavaBeans pattern
val animal = Animal()
animal.setWeight(10)
animal.setSpeed(7.5)
animal.setColor("Gray")

// Builder pattern
Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .build();

// 상속
class Plant // 암시적으로 Any 확장
class Plant : Any // 명시적으로 Any 확장

// 확장하려면 open으로 지정해야 한다.

open class Plant {
  var height: Int = 0
  open fun grow(height: Int) {

  }
}

class Tree : Plant() {
  override fun grow(height: Int) {
    this.height += height
  }
}

// 속성을 open으로 지정하고 재정의할 수 있다.
open class Plant {
  open var height: Int = 0
  open fun grow(height: Int) {}
}

class Tree : Plant() {
  override var height: Int = super.height
      get() = super.height
      set(value) { field = value }
    
  override fun grow(height: Int) {
    this.height += height
  }
  // final로 재정의할 수 있다.
  final override fun grow(height: Int) {
    this.height += height
  }

// JvmOverloads 애노테이션 사용
class KotlinView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr)

// JvmOverloads 애노테이션 사용 안 할 경
class KotlinView : View {
  constructor(context: Context?) : this(context, null)
  constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
    : super(context, attrs, defStyleAttr) {
      
    }
}


}

// ctrl + o, command + o : 멤버 재정의 명령 단축키
