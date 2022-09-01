let score = 88;

if (score >= 60) {
  console.log("pass");
} else console.log("fail");

if (score >= 90) {
  console.log("수");
} else if (score >= 80) {
  console.log("우");
}
else console.log("...");

let result = score >= 60 ? 'pass' : 'fail';
console.log(result);

let score2 = 99;

switch (Math.ceil(score2 / 10)) {
  case 10:
  case 9:
    console.log("A");
    break;
  case 8:
    console.log("B");
    break;
  default:
    console.log("실패");
    break;
}

let index = 0;
let sum = 0;
while (index < 100) {
  if ((index % 2) === 1) {
    sum += index;
  }
  console.log(sum);
  index++;
}
console.clear();

for (let i = 0; i <= 100; i++) {
  if (i % 2 === 1) {
    console.log(i);
  }
}

/**
 * 
 * @param {*} x 
 * @param {*} y 
 */
function sum(x, y) {
  return x + y;
}

console.log(sum(4,5));
