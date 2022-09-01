import { Student } from "./Student.js";

// Array를 이용하여 다수의 학생 관리
function StudentManager(){
  // this = {};
  this.array = [];
  // return this;
}

// 학생 등록
StudentManager.prototype.add = function(student){
  this.array.push(student);
}

// 학생번호로 조회
StudentManager.prototype.find = function(ssn){
  /*
  for (const student of this.array) {
    if(student.ssn === ssn){
      return student;
    }
  }
  */
 let student = this.array.find(function(student){
  // return true;
  return student.ssn === ssn;
 });
 return student;
}

// 학생 이름으로 조회
StudentManager.prototype.search = function(name){
  let student = this.array.search(function(student){
    return student.name === name;
  });
  return student;
}

// 학생 전체 목록 반환
StudentManager.prototype.list = function(){
  // return this.array.slice();
  return this.array.slice(0, this.array.length);
}

export {StudentManager};