let array = [1,2,3,4,5,6,7,8,9,10];

for (let i = 0; i < array.length; i++) {
  console.log(array[i]);
}

for (const i in array) {
  console.log(array[i]);
}

for (const value of array) {
  console.log(value);
}