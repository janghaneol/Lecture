'use strict'
// let array = new Array();

let array = [1, 2, 3, 4, 5, 6, '장한얼', true, 24.4, { name: '홍길동' }, new Date()];
// // console.dir(array);

// for (let i = 0; i < array.length; i++) {
//   const element = array[i];
//   console.log(element);
// }

// for (const index in array) {
//   {
//     const element = array[index];
//     console.log(element);
//   }
// }

// for (const value of array) {
//   console.log(value);
// }

array.forEach(function (value, index) {
  // console.log(`${value}, ${index}`);
  if ((typeof value) == Object) {
    console.log(value.name);
  } else {
    console.log(value);
  }
});

// Array.prototype의 주요 메소드
let arr = [1, 2];
arr.push(3);    // 배열에 추가로 값을 담는 메소드 push
arr.push(4, 5);
console.dir(arr);
console.log(arr);

console.log(arr.pop());
console.log(arr.length);

arr.unshift(10);
arr.unshift(11, 12);
console.dir(arr);
console.log(arr.shift());

const str = arr.join(' : '); //join메소드는 배열의 값을 문자열로 반환 (인자가 없을때는 ,로 찍히지만 인자가 있으면 해당 구분자로 바뀐다.)
console.log(str);

let language = 'Java, HTML, CSS, JavaScript';
let list = language.split(','); //문자열을 구분자로 구분하여 배열로 저장한다. (정규표현식 지원.)
console.dir(list);

let list2 = list.concat('SQL', 'Servlet', 'JSP');
console.dir(list2);

console.log(list2.slice(1, 3));  // 마지막수는 제외기때문에 HTML과 CSS를 출력하기위해선 1번째인 HTML 3번 
console.log(list2.slice(-4, -3));

console.log(list2.splice(1, 3));     // 해당 범위를 제거하고 불러온다.
console.log(list2);

list2.splice(0, 0, 'C', 'C++');
console.log(list2);

console.clear();

let nums = [3, 7, 1, 23, 5, 2, 3, 909];
// let nums1 = nums.sort();         // 배열을 문자열로 변환한후 유니코드값에 따라 정렬
// console.log(nums1);              // 제대로 정렬이 되지 않는다.
let sortNums = nums.sort(function(x , y){
  return x - y;
});
console.log(sortNums);

let reverseNums = nums.sort((x,y) => y-x);
console.log(reverseNums);

