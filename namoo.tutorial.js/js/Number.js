'use strict'    // 자바스크립트의 문법을 엄격히 함.

console.log(10);
// console.log(0516);
// console.log(0X54);  

//user = '장한얼';    //user라는 변수가 선언이 안돼있어도 원래 자바스크립트에선 사용이 가능했다. 하지만 'use strict'구문을 사용하면 사용 불가하다.
let user = '장한얼';
console.log(user);

console.log(Number.MAX_VALUE);
let num = 23233.232342492;
console.log(num.toFixed(2));  //소수점 2자리까지만 출력하는 메소드
console.log(num.toFixed());   //빈칸일경우 소수점을 다 날리고 출력

let strNum = "1004"; // 숫자지만 문자열이다.
let num2 = Number(strNum);  // 문자열을 숫자로 강제형변환 (자바의 parseInt와 같은 역할)
console.log(typeof num2);


