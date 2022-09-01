let user = {
  name : '장한얼',
  age : 30,
}

function show(){
  console.log(`${this.name} ${this.age}`);
}

// show();    --> undefined 가 떨어진다. user 스코프의 밖에있는 this가 윈도우의 객체이기 때문. 

show.call(user);    // 전역함수를 특정객체의 메소드로 사용하고싶을땐 call메소드를 사용.

function addProperty(name, value){
  this[name] = value;
}
addProperty('xxx', 'yyy');
console.dir(this);
console.log('xxx' in window);   // true

// addProperty.call(user,'gender', 'Man');  
addProperty.apply(user,['gernder', 'Man']);   // apply는 인자를 배열로 전달한다. 기능은 call메소드와 동일하다.
console.dir(user);

let addUserProperty = addProperty.bind(user);
addUserProperty('address', '대한민국');
addUserProperty('password', 1234);
console.dir(user);

// function doTask(){
//   console.log("함수에서 this는 윈도우 객체이다.");
//    console.dir(this);
//  }
// doTask();