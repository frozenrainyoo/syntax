class Dog {
  constructor() {
    this.age = 1;
  }

  get nextAge() {
    this.age = this.age + 1;
    return this.age;
  }
}
