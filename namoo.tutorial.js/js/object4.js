function Student(ssn, name, kor, eng, math) {
  // this = {};
  this.ssn = ssn;
  this.name = name;
  this.kor = kor;
  this.eng = eng;
  this.math = math;
  // return this;      --> this 메소드는 자동으로 호출.

  // 메소드 프로토타입에 추가
  Student.prototype.getSum = function () {
    return this.kor + this.eng + this.math;
  }
  Student.prototype.getAverage = function () {
    return this.getSum() / 3;
  }
  Student.prototype.toString = function () {
    return `${this.ssn} ${this.name} ${this.kor} ${this.eng} ${this.math} ${this.getAverage()}`;
  }

  // 공유하기위한 속성 추가
  Student.prototype.schoolName = "Korea중학교";
}
let student = new Student(1, '장한얼', 95, 80, 100);

// prototype chain 검증
let exist = student.hasOwnProperty('ssn');     // student는 object prototype을 상속. hasOwnProperty 메소드를 가지고있는건 오브젝트 프로토타입이다.

console.log(exist);

console.log(Student.prototype == student.__proto__);

console.log(Student.prototype.constructor === Student);
console.log(Student.constructor === Function);
console.log(student.constructor === Student);
console.log(student.constructor);
console.log(Student.constructor);

if(student.constructor === Student){
  console.log('Student로부터 만들어진 인스턴스.');
}

console.log(student instanceof Object);