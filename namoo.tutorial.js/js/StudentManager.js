import {Student} from "./Student.js";

// Array를 이용하여 다수의 학생 관리
function StudentManager(){
  // this = {};
  this.array = [];      //배열 생성자를 이용하여 Student의 객체들을 배열에 담는다.
  // return this;
}
// 학생 등록
StudentManager.prototype.add = function(student){
  this.array.push(student);
  console.dir(this.array);
}

// 학생 전체목록 반환
StudentManager.prototype.list = function(){
  return this.array.slice(0,this.array.length); 
}

//학생번호로 조회
StudentManager.prototype.find = function(ssn){
  /*
  for (const student of this.array) {
    if(student.ssn === ssn){
      return student;
    }
  }
  */
  return (this.array.find(function(student){
    return student.ssn === ssn;
  }));
}

export {StudentManager};