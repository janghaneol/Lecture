// 윈도우창 화면 중앙에 배치하기
function openCenter(url, name, width, height){
  let left = (screen.availWidth - width) / 2;
  let top = (screen.availHeight - height) / 2;
  let option = `left = ${left}, top = ${top}, width = ${width}, height = ${height}`;
  window.open(url, name, option);
  console.log(left,top);
}
openCenter('https://www.naver.com', 'win', 400, 200);

