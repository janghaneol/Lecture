
console.log("외부 스크립트 파일입니다.");
// 변수 재선언 가능.
var age = 20;
var age = 30;

console.log(age);

// 선언 이전에 사용 가능하다.
console.log(weight);  //undefined 된다.
var weight = 56.7;

console.log(weight);


// console.log(name1);   -> hoisting이 되지만 var함수와는 다르게 레퍼런스 오류가 난다. 값이 담겨져있지 않기때문에 TDZ(Temporary Dead Zone)에 가있기때문.
let name1 = 'Jack';
console.log(name1);

const MAX = 100; // const함수는 상수처리(변하지않음)
console.log(MAX);
console.log(Math.PI);