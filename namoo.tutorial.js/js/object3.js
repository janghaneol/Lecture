// 생성자 함수(객체 생성을 위한 템플릿)
// 프로토 타입을 이용한 메소드 공유
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
console.log(student.name);
console.log(student['ssn']);
console.log(student.schoolName);
// console.log(Student.prototype.schoolName);
console.dir(student);
// let student2 = Student(2, '장한얼', 100, 100, 100);  --> new를 써주지않으면 return이 자동으로 호출되지 않기때문에 undefine이 된다.
// console.log(student2);

console.log(student.toString());
console.log(student instanceof Student);
console.log(student.getSum());

// 자바 스크립트에는 미리 정의된 생성자 함수들이 존재하는데
// 얘네들을 표준 내장 객체라 한다.
// Object, String, Number, Math, Date, 
let obj = new Object();
// let obj = {};
obj.name = "xxxx";
obj.age = 10;
console.dir(obj);

let message = new String("js 어렵지 않다.");
let message2 = "js 어렵지 않다.";
const index = message2.indexOf('s');
console.log(index);