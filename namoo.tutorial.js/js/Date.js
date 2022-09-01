'use strict'

let now = new Date();
console.dir(now);
console.log(now.getFullYear());
console.log(now.getMonth()+1);   // 0부터 출력되므로 현재 월은 출력값에 +1을 해줘야한다.
console.log(now.toLocaleString());

let nowTime = now.getTime();
let someDay = new Date(1987, 3, 2);
let someTime = someDay.getTime();
let time = nowTime - someTime;
console.log(time);  //밀리 세컨드로 출력된다.
console.log(Math.round(time/(24*60*60*1000)));  //Math.round 메소드는 소수점 숫자를 올림해준다.




