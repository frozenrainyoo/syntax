// java의 anonymous class 익명 클래스
ServiceConnection serviceConnection = new ServiceConnection() {
  @Override
  public void onServiceDisconnected(ComponentName name) {

  }
  @Override
  public void onServiceConnected(ComponentName name, IBinder service) {

  }
}

// kotlin
val serviceConnection = object: ServiceConnection {
  override fun onServiceDisconnected(name: ComponentName?) { }
  override fun onServiceConnected(name: ComponentName?, service: IBinder?) { }
}


// 식 객체에 정의된 익명 객체 메소드를 호출 할 수 있다.
open class VideoPlayer {
  fun play() {
    println("Play video")
  }
}

interface Player {
  fun play()
  fun stop()
}

// 사용 법
val player = object: VideoPlayer(), Player {
  var duration: Double = 0.0

  fun stop() {
    println("Stop video")
  }
}

player.play() // Play video
player.stop() // Stop video
player.duration = 12.5
