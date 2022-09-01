import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";

let studentManager = new StudentManager();
//학생 등록
let student = new Student(1, '김기정', 90 , 100 , 50 );
studentManager.add(student);
studentManager.add(new Student(2, '장한얼', 100, 100, 100));
studentManager.add(new Student(3, '홍길동', 0, 0, 0));
studentManager.add(new Student(4, '이순신', 10, 30, 40));
studentManager.add(new Student(5, '도깨비', 70, 60, 100));
//전체 학생 목록 조회
const list = studentManager.list();
list.forEach(student => {
  console.log(student.toString());
});
// 학번으로 학생조회
const findStudent = studentManager.find(3);
if(findStudent){
  console.log(findStudent);
}else{
  console.log("번호에 해당하는 학생이 존재하지 않습니다.");
}