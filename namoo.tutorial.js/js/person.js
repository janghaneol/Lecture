class Person {

  #privateValue = "개인정보";   // -> 접근불가능
  static address = '대한민국';
  static shareMethod(){
    console.log("공통적으로 갖는 메소드");
  }

  constructor(name, age) {
    // this {};
    this.name = name;
    this.age = age;
    // return this;
  }
  // setter / getter 추가
  set name(name) {
    if (name == undefined) {
      throw error("이름을 입력해주세요");
    }
    // this.name = name;  -> 본인에게 재할당하므로 계속 반복한다.
    this._name = name;    // -> 변수를 하나 더 만들어서 할당해줘야한다.
  }

  get name() {
    return this._name;
  }

  set age(age) {
    if (age == undefined) {
      console.log("나이를 입력해주세요");
    }
    if (age < 0) {
      this._age = 0;
    }
    else {
      this._age = age;
    }
  }

  get age() {
    return this._age;
  }

  speak() {
    console.log(`${this.name} , ${this.age}`);
    console.dir(person);
  }
}
let person = new Person('장한얼', 30);
person.speak();
console.log(Person.address);
Person.shareMethod();
console.log(Person.privateValue);   // -> undefined가 출력.