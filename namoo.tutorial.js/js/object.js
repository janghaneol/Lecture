let myDog = {
  name : '루니',
  age : 7,
  kind : '비숑',
  eat : function() {
    console.log("밥을 먹습니다.");
  }
}

// 팩토리 함수
function createDog(name, age, kind){
  return{
    name : name,
    age : age,
    kind : kind,
    eat : function(){
      console.log("밥 먹는다.");
    }
  }
}

let yourDog = createDog('해피',3,'마르티즈');

console.dir(yourDog);