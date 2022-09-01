// 빈 객체를 생성하는 3가지방법.
let obj2 = new Object(null);
let obj1 = {
  name : '장한얼',
  age : 30
};  // 권장

let str = new Object('장한얼');
let num = new Object(100);

console.log(str.constructor === String);
console.log(num.constructor === Number);

let obj4 = obj1.constructor();  // 객체를 생성하는 방법이지만 복사개념은 아니다. obj1의 메소드가 전혀 담기지 않는다.

console.log(obj4);
console.log(obj1.toString());
console.log(obj1.toLocaleString()); 

console.log(obj1.hasOwnProperty('name')); // in이나 hasOwnProperty나 같은 결과. 방법이 2가지다
console.log(('name' in obj1));

console.log(obj1.propertyIsEnumerable('age'));  //age란 속성이 반복문을 통해 열거할 수 있는지 확인하는 메소드
for (const key in obj1) {
  if (Object.hasOwnProperty.call(obj1, key)) {
    console.log(`${key} : ${obj1[key]}`);
  }
}

console.log(Object.prototype.isPrototypeOf(obj1));

let str2 = new String("홍길동");
console.log(str2.toString());
console.log(str2.toLocaleString());

let now = new Date();                 // 시간에 관련된 객체 Date()
console.log(now.toString());          // 표준 표현
console.log(now.toLocaleString());    // 한국식 표현

let num2 = new Number(10);
let num3 = num2.valueOf();
console.log(typeof num3);

// Object의 정적메소드
function Dog(){};
Dog.log = function(){
  console.log("I'm Dog");
}
Dog.log();

// 객체 복사
// 얇은 복사
let obj3 = obj1;
// 깊은 복사
let obj5 = {};
Object.assign(obj5, obj1);  // 복사할 타겟을 뒤에 선언하고 덮어쓸 객체이름을 앞에 선언한다.
console.log(obj5);

// 객체의 키 목록 반환
let keys = Object.keys(obj1);
console.dir(keys);
// 객체의 값 목록 반환
let values = Object.values(obj1);
console.dir(values);
// 객체의 키와 값 목록 반환
let list = Object.entries(obj1);
console.dir(list);