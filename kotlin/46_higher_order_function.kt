// 함수를 작업으로서 제공

fun <T> filter(list: List<T>, predicate: (T) -> Boolean) {
    var visibleTasks = emptyList<T>()
    for (elem in list) {
        if (predicate(elem))
            visibleTasks += elem
    }
}

var visibleTasks = filter(tasks, { it.active })

// Observer 패턴
var listeners: List<()->Unit> = emptyList()
fun addListener(listener: () -> Unit) {
    listeners += listener
}

fun invokeListeners() {
    for (listener in listeners) {
        listener()
    }
}

// 스레드 작업 후 콜백
fun longOperationAsync(longOperation: ()->Unit, callback: ()->Unit) {
    Thread({
        longOperation()
        callback()
    }).start()
}

// 사용법
longOperationAsync(
    longOperation = { Thread.sleep(1000L) },
    callback = { print("After second") }
) // 1초 지연 후 After second 출력
