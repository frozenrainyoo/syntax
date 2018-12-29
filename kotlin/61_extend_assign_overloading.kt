// 확장 함수를 이용한 연산자 오버로딩

// 예를 들어 RxJava에서 구독을 관리할 때는 CompositeDisposable 함수를 이요한다.
// 이 컬렉션은 add 메소드를 이용해 새로운 요소를 추가한다.
val subscriptions = CompositeDisposable()
subsciptions.add(repository
  .getAllCharacters(qualifiedSearchQuery)
  .subscribeOn(Schedulers.io())
  .observeOn(AndroidSchedulers.mainThread())
  .subscribe(this::charactersLoaded, view::showError))

// 가변 컬렉션에 요소를 추가하는 코틀린의 표준 방식은 plusAssign +=를 이용하는 것이다.
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
  add(disposable)
}

subsciptions += repository
  .getAllCharacters(qualifiedSearchQuery)
  .subscribeOn(Schedulers.io())
  .observeOn(AndroidSchedulers.mainThread())
  .subscribe(this::charactersLoaded, view::showError)
