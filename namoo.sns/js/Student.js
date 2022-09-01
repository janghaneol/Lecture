function Student(ssn, name, korea, english, math){
  // this = {};
  this.ssn = ssn;
  this.name = name;
  this.korea = korea;
  this.english = english;
  this.math = math;
  // return this;
}
// 메소드 프로토타입에 추가
Student.prototype.getSum = function(){
  return this.korea + this.english + this.math;
}

Student.prototype.getAverage= function(){
  return (this.getSum() / 3).toFixed(1);
}

// Object의 toString() Overringding
Student.prototype.toString = function(){
  return `<td>${this.ssn}</td><td>${this.name}</td><td>${this.korea}</td><td>${this.english}</td><td>${this.math}</td><td>${this.getSum()}</td><td>${this.getAverage()}</td>`;
}

// 공유하기 위한 속성 추가
Student.prototype.schoolName = "Korea 중학교";

export {Student};