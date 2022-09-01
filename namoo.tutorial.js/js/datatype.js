// 동적 Typing (값이 담기는 순간 데이터타입이 결정된다.)
let age = 20;
console.log(typeof age);
let weight = 77.888;

age = '장한얼'; 
console.log(typeof age);
console.log(age);

console.log(10/0);
console.log(-10/0);

console.log(age / 10);  // NaN(Not a Number) 가 출력된다.

console.log(typeof NaN);
console.log(typeof Infinity);

let name = '장한얼';
let name2 = '장한얼';
console.log("김기정" + "바보" + age);

let message = `김기정입니다.. ${age} ${50+20}` ;  // "" 나 ''는 문자열을 연결할때 +를 써줘야하지만, ``로 작성할 경우 $를 이용해 문자를 연결할 수 있고, 연산결과까지 출력이 가능하다.
console.log(message);

console.log(true);
console.log(false);
console.log(10>5);

// 0, '', undefined, null -> Js에서는 해당하는 값들이 false로 인식된다.

console.log(typeof null);     // object라는 결과값이 출력. ->  JS 설계과정의 오류이다.
console.log(typeof undefined);

// 객체타입 (래퍼런스타입)
// 객체리터럴표현식 사용

let person = {
  name : "장한얼",
  age : 30,
  weight : 77.7777,
  class : 'JAVA',
  sayHello : function(){
    console.log("hello");
  }
};

// 객체 변경
person.name = "홍길동";


// 객체 출력 방식 2가지.
console.log(person['weight']);    // 주로 Css에서 많이 사용됨.
console.log(person.name);
person.sayHello();


let str = "java Script";
let char = str.charAt(5);   // 5번째 문자를 불러온다.(일시적 객체화)
console.log(char);
console.log(typeof char);
