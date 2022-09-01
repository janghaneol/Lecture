'use strict'

// const Math = {};                   -> Math객체는 늘 선언되어있는 상태.
// Math.abs = function(){......};

console.log(Math.floor(1.699999999999));  //소수점 전부 내림
console.log(Math.ceil(1.6999999999));     //소수점이 있으면 올림
console.log(Math.round(1.6999999999));
console.log(Math.PI);
console.log(Math.max(5,3,5120,23,42));    //최댓값을 출력하는 메소드

// 1~100 임의의 값
console.log(Math.floor((Math.random()*100) +1 )); //floor는 소수점아랫부분을 전부 버린다.

