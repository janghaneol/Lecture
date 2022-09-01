"use strict";

import { Student } from "./Student.js";
import { StudentManager } from "./StudentManager.js";

let studentManager = new StudentManager();
// 테스트를 위한 학생등록
let student = new Student(1, '김기정', 90, 100, 50);
studentManager.add(student);
studentManager.add(new Student(2, '이순신', 100, 100, 100));
studentManager.add(new Student(3, '강감찬', 90, 90, 80));
studentManager.add(new Student(4, '을지문덕', 77, 88, 90));
studentManager.add(new Student(5, '손흥민', 99, 99, 99));
// 이벤트 타겟에 이벤트리스너 등록
document.querySelector("#add").addEventListener("click", function (event) {
  // 화면에서 값 읽어오기
  var ssn = document.querySelector("#ssn").value;
  var name = document.querySelector("#name").value;
  var kor = parseInt(document.querySelector("#kor").value);
  var eng = parseInt(document.querySelector("#eng").value);
  var math = parseInt(document.querySelector("#math").value);
  let student = new Student(ssn, name, kor, eng, math);
  studentManager.add(student);

  //  등록 후 전체 목록 화면 출력
  const list = studentManager.list();

  // 전체학생목록 조회
  document.querySelector("#allSearch").addEventListener("click", function (event) {
    printList(list);
    console.dir(list);
  })

  // 학번으로 조회
  document.querySelector("#find").addEventListener("click", function (event) {
    // const findStudent = studentManager.find(document.querySelector("#ssn").value);
    const findStudent = studentManager.find(document.querySelector("#ssn").value);
    findStudent = parseInt(findStudent);
    console.log(findStudent);
    let table = "<table>"
    if (findStudent) {
      table += "<tr>";
      // table += `<td>${findStudent.toString()}</td>`
      table += `<td>${findStudent.ssn}</td><td>${findStudent.name}</td><td>${findStudent.korea}</td><td>${findStudent.english}</td><td>${findStudent.math}</td><td>${findStudent.getSum()}</td><td>${findStudent.getAverage()}</td>`;
      table += "</tr>";
    }
    else {
      alert("번호에 해당하는 학생이 존재하지 않습니다.");
    }
    table +="</table>"
    document.querySelector("#list").innerHTML = table;
  });
});

// 이름으로 조회




// 목록 화면 출력
function printList(list) {
  let table = "<table>";
  for (const student of list) {
    table += "<tr>";
    table += `<td>${student.ssn}</td><td>${student.name}</td><td>${student.korea}</td><td>${student.english}</td><td>${student.math}</td><td>${student.getSum()}</td><td>${student.getAverage()}</td>`;
    table += "</tr>";
  }
  table += "</table>"

  document.querySelector("#list").innerHTML = table;
}

