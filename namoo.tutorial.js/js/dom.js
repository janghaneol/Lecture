// 태그이름으로 엘리먼트 접근
let array = document.getElementsByTagName('p');
console.dir(array);
for (const element of array) {
  console.log(element);
}
// 태그 id로 엘리먼트 접근하는 방법.
let ul = document.getElementById('dom');
console.log(ul);
// 태그 class로 엘리먼트 접근
array = document.getElementsByClassName('list');
console.log(array);
for (const li of array) {
  li.style.color = 'blue';
}
// name 속성으로 접근
array = document.getElementsByName("bom");
console.log(array);

// 아이디 선택자로 접근
let ul2 = document.querySelector("#dom");
ul2.style.background = "red";

// 클래스 선택자로 접근
let list2 = document.querySelectorAll(".list");
for (const iterator of list2) {
  iterator.style.background = "gold";
  iterator.style.border = "1px solid black"
}

