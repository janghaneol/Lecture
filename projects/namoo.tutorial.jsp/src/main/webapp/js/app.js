"use strict";
import { Validator } from "./validator.js";

/*
// 이벤트타겟에 이벤트리스너 등록
document.querySelector("#dupCheck").addEventListener("click", function(event) {
	loadDupCheck();
});
*/

var id = document.querySelector("#id");
id.addEventListener("keyup",()=>{
	if(id.value.length<6 || id.value.length>8){
		showError("ID는 6~8자만 사용 가능합니다.");
	}
	else{
		requestIdDupCheck();
	}
});


function requestIdDupCheck(){
	let user = {
		id: `${id.value}`
	};

	const option = {
		method: "POST",
		Headers:{"Content-Type":"application/json"} ,
		body:JSON.stringify(user)
	}
	fetch("idDupCheck.jsp",option)
		.then(Response => Response.json())
		.then(Response=> {
			showLog(Response);
		})
};

function showLog(){
	
}


document.querySelector("#signup").addEventListener("submit", function(event) {
	// 유효성 검증
	const inputId = document.querySelector("#id").value;
	if(Validator.isNull(inputId)){
		alert('아이디를 입력하여 주세요.');
		
	}
	
	if(!Validator.isId(inputId)){
		alert('아이디는 영어소문자와 숫자 6~8자 사용가능합니다.');
		event.preventDefault();
	}
	
});


function loadDupCheck() {
	const popWindow = openWindowCenter("idDupForm.jsp", 'pop', 370, 120);
}

function openWindowCenter(url, name, width, height) {
	let left = (screen.availWidth - width) / 2;
	let top = (screen.availHeight - height) / 2;
	console.log(left, top);
	let option = `left=${left},top=${top},width=${width},height=${height}`;
	return open(url, name, option);
}