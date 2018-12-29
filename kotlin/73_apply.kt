val button = Button(context)
button.text = "Click me"
button.isVisible = true
button.setOnClickListener { }
this.button = button

// =>

button = Button(context).apply {
  text = "Click me"
  isVisible = true
  setOnClickListener { }
}
