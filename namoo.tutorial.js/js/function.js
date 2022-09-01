// 함수 선언문
function showMessage(){
  console.log("함수선언문 방식");
  // return undefined;    --> 명시하지않아도 늘 return값이 undefined가 되어있다.
}

function showMessage2(message) {
  if (message === undefined) {
    // throw new Error("똑바로 입력하세요.");
    message = "Hello.";
  }
  console.log(message);
  // return undefined;  
}
// 함수 호출
showMessage();
showMessage2();     // 자바는 함수와 호출하는 매개변수의 갯수가 같지 않아도 호출이 된다.
showMessage2("hellohello");

const what = showMessage();   //매개변수를 명시하지않으면 undefined가 호출.
console.log(what);

function showMessage2(message="오늘 수업은 여기서 마칩니다..") {    //매개변수를 명시하지않을시 이 메세지가 출력된다.
  console.log(message);
  // return undefined;  
}
showMessage2();

function sum(...args){
  let result = 0;
  for (const num of args) {
    result += num;
  }
  return result;
}

sum(5,6,7,8,9,10);
console.log(sum(5,6,7,8,9,10));