// 단일 식 함수
fun square(x: Int): Int = x * x

// 블록 본체가 있는 함수
fun square(x: Int): Int {
  return x * x
}

// 안드로이드 사용 예제
class AddressAdapter: ItemAdapter<AddressAdapter.ViewHolder>() {
  override fun getLayoutId() = R.layout.choose_address_view
  override fun onCreateViewHolder(itemView: View) = ViewHolder(itemView)
  ...
}

// 단일 식 함수, when을 이용해 코드 가독성을 크게 개선하는 방법
fun valueFromBooking(key: String, booking: Booking?) = when(key) {
  "patient.nin" -> booking?.patient?.nin
  "patient.email" -> booking?.patient?.email
  "patient.phone" -> booking?.patient?.phone
  "comment" -> booking?.comment
  else -> null
}

override fun onOptionsItemSelected(item: MenuItem): Boolean = when
{
  item.itemId == android.R.id.home -> {
    onBackPressed()
    true
  }
  else -> super.onOptionsItemSelected(item)
}

fun textFormatted(text: String, name: String) = text
                  .trim()
                  .capitalize()
                  .replace("{name}", name)

val formatted = textFormatted("hello, {name}", "Marcin") // Hello, Marcin
