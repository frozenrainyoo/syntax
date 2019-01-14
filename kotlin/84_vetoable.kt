// vetoable
var list: List<String> by Delegates.vetoable(emptyList())
{
  _, old, new ->
    new.size > old.size
}
// 이 대리자를 사용하면 변경할 리스트가 원래보다 더 많은 항목을 포함하지 않으면 값이 변경되지 않는다.
