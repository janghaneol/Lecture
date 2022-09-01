document.querySelector("#tf").addEventListener("focus",function(event){
  event.target.style.backgroundColor = 'gold';
});

document.querySelector("#tf").addEventListener("blur",function(event){
  event.target = alert('hello');
});

document.querySelector("#tf2").addEventListener("change",function(event){
  // console.log(event.target.value);
  console.log(this.value);
  // event.target.value="";
  this.value="";
  this.focus();
});

document.querySelector("#pet-select").addEventListener("change",function(event){
  let selectedValue = this.options[this.selectedIndex].value;
  let selectedValue2 = this.options[this.selectedIndex].text;
  alert(selectedValue);
  alert(selectedValue2);
  // console.log(this.value+" 선택");
});