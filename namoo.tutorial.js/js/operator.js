let str = 100;
let num = 10;
console.log(str + num);   // 자료형이 다르기때문에 자동형변환이 되지않아 +연산은 이어져서 출력되지만
console.log(str * num);   // *연산은 자동형변환이 되어 알맞은 값이 출력된다.
console.log(typeof(str*num));

if(num==str && num===str){
  console.log("num과 str의 값과 자료형이 같습니다.");
}else if(num == str){
  console.log("num과 str의 값이 같습니다.");
}else if(num === str){
  console.log("num과 str의 자료형이 같습니다.");
}else if (num != str) console.log("num과 str이 같지 않습니다.");

console.log(0 == false);  // true가 출력된다. (0은 false) 0이외의 값은 true가 출력.
console.log(0 === false);  // false가 출력된다. 0과 false의 값은 같으나 자료형은 다르다.
console.log('' == false);
console.log('' === false);
console.log(null == undefined);
console.log(null === undefined);


if(10){
  console.log("참입니다.");
}

let a = 10;
console.log(a++);
console.log(++a);

