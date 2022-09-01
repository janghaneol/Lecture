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
    return (this.getSum() / 3).toFixed(2);
  }
  // Object의 toString() Overridding
  Student.prototype.toString = function () {
    return `${this.ssn} ${this.name} ${this.kor} ${this.eng} ${this.math} ${this.getAverage()}`;
  }

  // 공유하기위한 속성 추가
  Student.prototype.schoolName = "Korea중학교";
}

export {Student};  