// 데코레이션 패턴 Decorator pattern, Wrapper pattern 이라고도 한다.
// http://upload.wikimedia.org
// 자바에서 쉽게 볼 수 있는 데코레이터의 사용 예에는 InputStream이 있다.

class ZeroElementListDecorator(val arrayAdapter: ListAdapter) :
ListAdapter by arrayAdapter {
  override fun getCount(): Int arrayAdapter.count + 1
  override fun getItem(position: Int): Any? = when {
    position == 0 -> null
    else -> arrayAdapter.getItem(position - 1)
  }

  override fun getView(position: Int, convertView: View?, parent: ViewGroup)): View = when {
    position == 0 -> parent.content.inflator.inflate(R.layout.null_element_layout, parent false)
    else -> arrayAdapter.getView(position - 1, convertView, parent)
  }

  override fun getItemId(position: Int): Long = when {
    position == 0 -> 0
    else -> arrayAdapter.getItemId(position -1)
  }
}

// 사용법
val araryList = findViewById(R.id.list) as ListView
val list = listOf("A", "B", "C")
val arrayAdapter = ArrayAdapter(this,
  android.R.layout.simpl_list_item_1, list)
arrayList.adapter = ZeroElementListDecorator(arrayAdapter)
