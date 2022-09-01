"use strict";
// 유효성 검증 객체
let Validator = {};

Validator.isNull = function(value){
  return value == undefined || value == '';
}

Validator.isId = function(value) {
	// 영문자로 시작하는 영문자 또는 숫자 6~8자 
	var regex = /^[a-z]+[a-z0-9]{5,7}$/g;
	return regex.test(value);
}

export { Validator };